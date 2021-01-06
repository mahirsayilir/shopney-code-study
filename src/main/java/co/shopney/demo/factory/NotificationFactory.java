package co.shopney.demo.factory;

import co.shopney.demo.manager.NotificationManager;
import co.shopney.demo.manager.imp.ConsoleNotificationManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

@Getter
@Setter
public class NotificationFactory implements FactoryBean<NotificationManager> {

  private NotificationProvider provider;

  @Override public NotificationManager getObject() throws Exception {
    switch (provider) {
      case CONSOLE:
        return new ConsoleNotificationManager();
      default:
        return null;
    }
  }

  @Override public Class<?> getObjectType() {
    return NotificationManager.class;
  }
}
