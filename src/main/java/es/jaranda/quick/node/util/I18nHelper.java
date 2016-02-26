
package es.jaranda.quick.node.util;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * Provides helpfully class to use i18n
 */
@Component
public class I18nHelper {
    
    @Autowired
    private MessageSource messageSource;
    
    public String getMessage(String code, String... args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
