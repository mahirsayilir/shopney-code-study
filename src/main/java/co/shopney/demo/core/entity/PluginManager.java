package co.shopney.demo.core.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
public class PluginManager {

  private boolean enabled;
  private Date lastModifiedDate;
  @DBRef
  private Plugin plugin;
}
