
package es.jaranda.quick.node.app;

import es.jaranda.quick.node.config.ApplicationContext;
import org.springframework.boot.SpringApplication;

public class MainApp {
    
    private MainApp() {
        // no instanciable
    }
    
    public static void main(String[] args) {
        SpringApplication.run(ApplicationContext.class);
    }
    
}
