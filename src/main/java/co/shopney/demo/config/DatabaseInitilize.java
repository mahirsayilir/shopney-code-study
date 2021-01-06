package co.shopney.demo.config;

import co.shopney.demo.core.entity.Plugin;
import co.shopney.demo.repository.PluginRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitilize {

  @Autowired PluginRepository pluginRepository;

  @Bean
  public void initialize() {
    pluginRepository.deleteAll();
    pluginRepository.saveAll(generatePlugins());
  }

  private List<Plugin> generatePlugins() {
    List<String> pluginNames = Arrays.asList("Benim Sayfam", "Günlük Satış Raporu", "Google Analytics", "Chatmate", "ReviewMe", "GiftSend");
    List<Plugin> plugins = new ArrayList<>();
    for (String pluginName : pluginNames) {
      Plugin plugin = new Plugin();
      plugin.setPluginName(pluginName);
      if (pluginNames.indexOf(pluginName) == 0) {
        plugin.setDefault(true);
      }
      plugins.add(plugin);
    }
    return plugins;
  }

}
