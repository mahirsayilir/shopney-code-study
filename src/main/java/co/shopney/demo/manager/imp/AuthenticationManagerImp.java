package co.shopney.demo.manager.imp;

import co.shopney.demo.core.entity.Shop;
import co.shopney.demo.manager.AuthenticationManager;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationManagerImp implements AuthenticationManager {

  @Autowired HttpSession session;

  private final static String SHOP_SESSION_ATTRIBUTE = "shop";

  @Override public void setShop(Shop shop) {
    session.setAttribute(SHOP_SESSION_ATTRIBUTE, shop);
  }

  @Override public Optional<Shop> getShop() {
    Shop shop = (Shop) session.getAttribute(SHOP_SESSION_ATTRIBUTE);
    return Optional.ofNullable(shop);
  }

  @Override public void deleteShop() {
    session.removeAttribute(SHOP_SESSION_ATTRIBUTE);
  }
}
