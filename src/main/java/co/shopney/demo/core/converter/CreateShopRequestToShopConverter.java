package co.shopney.demo.core.converter;

import co.shopney.demo.core.converter.base.BaseConverter;
import co.shopney.demo.core.entity.Shop;
import co.shopney.demo.core.request.CreateShopRequest;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class CreateShopRequestToShopConverter implements BaseConverter<CreateShopRequest, Shop> {

  @Override public Shop convert(CreateShopRequest input) {
    Shop shop = new Shop();
    shop.setShopName(input.getShopName());
    shop.setPassword(input.getPassword());
    shop.setEnabled(true);
    shop.setCreatedAt(new Date());
    shop.setUpdatedAt(new Date());
    return shop;
  }

}
