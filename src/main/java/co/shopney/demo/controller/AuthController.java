package co.shopney.demo.controller;

import co.shopney.demo.core.request.CreateShopRequest;
import co.shopney.demo.core.request.LoginRequest;
import co.shopney.demo.core.response.GenericResponse;
import co.shopney.demo.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private final ShopService shopService;

  @PostMapping(value = "/login")
  public GenericResponse login(@RequestBody LoginRequest request) {
    return shopService.login(request);
  }

  @PostMapping(value = "/register")
  public GenericResponse create(@RequestBody CreateShopRequest request) {
    return shopService.createShop(request);
  }

}
