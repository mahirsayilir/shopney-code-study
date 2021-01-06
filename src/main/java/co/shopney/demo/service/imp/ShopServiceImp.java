package co.shopney.demo.service.imp;

import co.shopney.demo.core.converter.CreateShopRequestToShopConverter;
import co.shopney.demo.core.dto.PluginDto;
import co.shopney.demo.core.entity.Plugin;
import co.shopney.demo.core.entity.PluginManager;
import co.shopney.demo.core.entity.Shop;
import co.shopney.demo.core.request.CreateShopRequest;
import co.shopney.demo.core.request.LoginRequest;
import co.shopney.demo.core.response.GenericResponse;
import co.shopney.demo.exception.UnauthorizedException;
import co.shopney.demo.manager.AuthenticationManager;
import co.shopney.demo.manager.NotificationManager;
import co.shopney.demo.repository.PluginRepository;
import co.shopney.demo.repository.ShopRepository;
import co.shopney.demo.service.ShopService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static co.shopney.demo.util.ResponseStringUtils.CREDENTIAL_INVALID;
import static co.shopney.demo.util.ResponseStringUtils.SHOP_IS_DISABLED;
import static co.shopney.demo.util.ResponseStringUtils.SHOP_NAME_EXIST;

@Service
@RequiredArgsConstructor
public class ShopServiceImp implements ShopService {

  @Autowired ShopRepository shopRepository;
  @Autowired PluginRepository pluginRepository;
  @Autowired AuthenticationManager authenticationManager;
  @Autowired PasswordEncoder passwordEncoder;
  @Autowired NotificationManager notificationManager;

  private final CreateShopRequestToShopConverter converter;

  @Override public GenericResponse<?> createShop(CreateShopRequest request) {
    Optional<Shop> shopByShopName = shopRepository.findShopByShopName(request.getShopName());
    if (!shopByShopName.isPresent()) {
      Shop shop = converter.convert(request);
      shop.setPlugins(generateAvailablePlugins());
      shopRepository.save(shop);
      return GenericResponse.ok();
    } else {
      return GenericResponse.bad(SHOP_NAME_EXIST);
    }
  }

  @Override public GenericResponse<?> togglePlugin(String pluginId) {
    Optional<Shop> shop = authenticationManager.getShop();
    if (shop.isPresent()) {
      for (PluginManager pluginManager: Objects.requireNonNull(shop.get().getPlugins())) {
        if (pluginManager.getPlugin().getId().equals(pluginId)) {
          pluginManager.setEnabled(!pluginManager.isEnabled());
          pluginManager.setLastModifiedDate(new Date());
          shopRepository.save(shop.get());
          notificationManager
              .withTarget(shop.get())
              .withMessage(generateNotificationMessage(pluginManager))
              .send();
        }
      }
    } else {
      throw new UnauthorizedException();
    }
    return GenericResponse.ok();
  }

  @Override public GenericResponse<?> login(LoginRequest request) {
    Optional<Shop> shopOptional =
        shopRepository.findShopByShopNameAndPassword(request.getShopName(), request.getPassword());
    if (!shopOptional.isPresent()) {
      return GenericResponse.bad(CREDENTIAL_INVALID);
    }
    if (!shopOptional.get().isEnabled()) {
      return GenericResponse.bad(SHOP_IS_DISABLED);
    }
    authenticationManager.setShop(shopOptional.get());
    return GenericResponse.ok();
  }

  @Override public GenericResponse<?> getAvailablePlugins() {
    Optional<Shop> shop = authenticationManager.getShop();
    List<PluginDto> plugins = new ArrayList<>();
    if (shop.isPresent()) {
      for (PluginManager pluginManager : Objects.requireNonNull(shop.get().getPlugins())) {
        PluginDto plugin = new PluginDto();
        plugin.setPluginId(pluginManager.getPlugin().getId());
        plugin.setPluginName(pluginManager.getPlugin().getPluginName());
        plugin.setEnabled(pluginManager.isEnabled());
        plugin.setLastModifiedDate(pluginManager.getLastModifiedDate());
        plugins.add(plugin);
      }
    } else {
      throw new UnauthorizedException();
    }
    return GenericResponse.ok(plugins);
  }

  @Override public GenericResponse<?> disableShop() {
    Optional<Shop> shop = authenticationManager.getShop();
    if (shop.isPresent()) {
      shop.get().setEnabled(false);
      shop.get().setUpdatedAt(new Date());
      shopRepository.save(shop.get());
      authenticationManager.deleteShop();
    } else {
      throw new UnauthorizedException();
    }
    return GenericResponse.ok();
  }

  private String generateNotificationMessage(PluginManager pluginManager) {
    return pluginManager.getPlugin().getPluginName() + " isimli eklentiyi " + (pluginManager.isEnabled() ? "Aktif" : "Pasif") + " Etti.";
  }

  private List<PluginManager> generateAvailablePlugins() {
    List<Plugin> plugins = pluginRepository.findAll();
    List<PluginManager> pluginManagers = new ArrayList<>();
    for (Plugin plugin: plugins) {
      PluginManager pluginManager = new PluginManager();
      pluginManager.setLastModifiedDate(new Date());
      pluginManager.setEnabled(plugin.isDefault());
      pluginManager.setPlugin(plugin);
      pluginManagers.add(pluginManager);
    }
    return pluginManagers;
  }
}
