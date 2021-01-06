package co.shopney.demo.manager;

import co.shopney.demo.config.NotificationFactoryConfig;
import co.shopney.demo.core.entity.Shop;
import co.shopney.demo.factory.NotificationFactory;
import co.shopney.demo.factory.NotificationProvider;

/**
 * {@link NotificationManager} is a generic notification sender. It's bounded to {@link NotificationFactory}
 * {@link NotificationFactory} decide which {@link NotificationManager} will be using on runtime
 * configuration on {@link NotificationFactoryConfig} will set on of types of {@link NotificationProvider}
 */
public abstract class NotificationManager {

  public abstract NotificationManager withMessage(String message);

  public abstract NotificationManager withTarget(Shop shop);

  public abstract void send();

}
