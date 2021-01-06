package co.shopney.demo.service;

import co.shopney.demo.core.request.CreateShopRequest;
import co.shopney.demo.core.request.LoginRequest;
import co.shopney.demo.core.response.GenericResponse;

public interface ShopService {

  GenericResponse<?> createShop(CreateShopRequest request);

  GenericResponse<?> togglePlugin(String pluginId);

  GenericResponse<?> login(LoginRequest request);

  GenericResponse<?> getAvailablePlugins();

  GenericResponse<?> disableShop();

}
