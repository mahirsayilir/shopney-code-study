package co.shopney.demo.core.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PluginDto {

  public String pluginId;
  public String pluginName;
  public Boolean enabled;
  public Date lastModifiedDate;

}
