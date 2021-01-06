package co.shopney.demo.core.converter.base;

import co.shopney.demo.core.entity.base.BaseEntity;
import co.shopney.demo.core.request.base.BaseRequest;

/**
 * This is a converting interface for convert {@link BaseRequest} objects to {@link BaseEntity} objects
 * @param <T>
 * @param <U>
 */
public interface BaseConverter<T extends BaseRequest, U extends BaseEntity> {

  U convert(T input);

}
