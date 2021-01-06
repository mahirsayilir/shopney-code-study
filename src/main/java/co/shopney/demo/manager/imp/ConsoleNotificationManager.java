package co.shopney.demo.manager.imp;

import co.shopney.demo.core.entity.Shop;
import co.shopney.demo.manager.NotificationManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleNotificationManager extends NotificationManager {

  private String message;
  private Shop shop;

  @Override public NotificationManager withMessage(String message) {
    this.message =message;
    return this;
  }

  @Override public NotificationManager withTarget(Shop shop) {
    this.shop = shop;
    return this;
  }

  @Override public void send() {
    log.info(shop.getShopName() + ", " + message);
  }
}
