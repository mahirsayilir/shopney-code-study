package co.shopney.demo.core.entity;

import co.shopney.demo.core.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "plugins")
public class Plugin extends BaseEntity {
  private String pluginName;
  private boolean isDefault;
}
