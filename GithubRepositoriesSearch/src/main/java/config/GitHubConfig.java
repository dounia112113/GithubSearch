package config;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Singleton class to load properties needed Github search repositories
 *
 * @author  Dounia Mdarhri Alaoui
 * @version 1.0
 * @since   2018-06-12
 */
public enum GitHubConfig {
    INSTANCE;

    private Properties config = new Properties();

    private final Logger logger = LogManager.getLogger(GitHubConfig.class);


    GitHubConfig() {
        loadProperties();
    }

    private void loadProperties() {
        String propertiesFileName = "config.properties";
        try {
            config.load(new FileInputStream(propertiesFileName));
        } catch (IOException e) {
            logger.error("There was an error while loading the properties: " + propertiesFileName, e);
            logger.warn("Only System properties will be used!!!");
        }

    }

    public Properties getConfig() {
        return config;
    }

}