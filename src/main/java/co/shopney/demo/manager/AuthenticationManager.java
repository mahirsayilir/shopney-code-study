package co.shopney.demo.manager;

import co.shopney.demo.core.entity.Shop;
import java.util.Optional;

/**
 * {@link AuthenticationManager} is a manager that handle session operations.
 * Session operations are related with {@link Shop}
 */
public interface AuthenticationManager {

  void setShop(Shop shop);

  Optional<Shop> getShop();

  void deleteShop();

}
