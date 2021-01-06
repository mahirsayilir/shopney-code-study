package co.shopney.demo.core.entity;

import co.shopney.demo.core.entity.base.BaseAuditEntity;
import com.mongodb.lang.Nullable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "shops")
public class Shop extends BaseAuditEntity {

  @Indexed(unique=true)
  private String shopName;
  private String password;

  @Nullable
  private List<PluginManager> plugins;

}
