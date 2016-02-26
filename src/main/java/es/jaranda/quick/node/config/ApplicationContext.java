
package es.jaranda.quick.node.config;

import static es.jaranda.quick.node.constants.ConfigurationConstants.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(PROP_COMPONENT_SCAN_PACKAGES)
public class ApplicationContext {

    /**
     * This bean provides support for i18n
     * @param i18nResources Path into classpath of 18n resources
     * @return Bean to provide support for i18n
     */
    @Bean
    ResourceBundleMessageSource messageSource(
            @Value(PROP_I18N_RESOURCES) String i18nResources
    ) {
        ResourceBundleMessageSource bean = 
                new ResourceBundleMessageSource();
        bean.setBasename(i18nResources);
        
        return bean;
    }
    
}
