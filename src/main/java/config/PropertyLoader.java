package config;


import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

public class PropertyLoader {
    private static CompositeConfiguration config;
    private static PropertyLoader instance;

    public PropertyLoader() {
    }

    public static PropertyLoader getInstance() {
        if (instance == null) {
            instance = new PropertyLoader();
            load();
        }
        return instance;
    }

    private static void load() {
        try {
            config = new CompositeConfiguration();
            config.addConfiguration(new SystemConfiguration());
            config.addConfiguration(new PropertiesConfiguration("config.properties"));
        } catch (org.apache.commons.configuration.ConfigurationException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public String getURL() {
        return config.getString("base.url");
    }


}
