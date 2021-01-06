package co.shopney.demo.core.entity.base;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseAuditEntity extends BaseEntity {
  private Date createdAt;
  private Date updatedAt;
  private boolean enabled;
  private boolean deleted;
}
