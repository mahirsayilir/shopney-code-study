package co.shopney.demo.repository;

import co.shopney.demo.core.entity.Shop;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends MongoRepository<Shop, Integer> {

  Optional<Shop> findShopById(String id);

  Optional<Shop> findShopByShopNameAndPassword(String shopName, String password);

  Optional<Shop> findShopByShopName(String shopName);

}
