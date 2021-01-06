package co.shopney.demo.controller;

import co.shopney.demo.core.response.GenericResponse;
import co.shopney.demo.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {

  private final ShopService shopService;

  @GetMapping(value = "/plugins")
  public GenericResponse getShopAvailablePlugins() {
    return shopService.getAvailablePlugins();
  }

  @PutMapping(value = "/plugins/{pluginId}")
  public GenericResponse togglePlugin(@PathVariable String pluginId) {
    return shopService.togglePlugin(pluginId);
  }

  @DeleteMapping(value = "/")
  public GenericResponse disable() {
    return shopService.disableShop();
  }

}
