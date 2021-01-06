package co.shopney.demo.config;

import co.shopney.demo.factory.NotificationFactory;
import co.shopney.demo.factory.NotificationProvider;
import co.shopney.demo.manager.NotificationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationFactoryConfig {

  @Bean
  public NotificationFactory notificationFactory() {
    NotificationFactory notificationFactory = new NotificationFactory();
    // @Todo: If env == PROD else if DEV
    notificationFactory.setProvider(NotificationProvider.CONSOLE);
    return notificationFactory;
  }

  @Bean NotificationManager notificationManager() throws Exception {
    return notificationFactory().getObject();
  }
}
