package co.shopney.demo.repository;

import co.shopney.demo.core.entity.Plugin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PluginRepository extends MongoRepository<Plugin, Integer> {

}
