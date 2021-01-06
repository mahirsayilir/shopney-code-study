package co.shopney.demo.core.request;

import co.shopney.demo.core.request.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateShopRequest extends BaseRequest {
  public String shopName;
  public String password;
}
