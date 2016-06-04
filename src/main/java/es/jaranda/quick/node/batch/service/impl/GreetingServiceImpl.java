
package es.jaranda.quick.node.batch.service.impl;

import es.jaranda.quick.node.batch.service.GreetingService;
import static es.jaranda.quick.node.constants.i18n.GreetingBatchI18nConstants.*;
import es.jaranda.quick.node.util.I18nHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    private static final Logger LOG = 
            Logger.getLogger(GreetingServiceImpl.class);
    
    @Autowired
    private I18nHelper i18n;

    @Override
    public void greet(String message) {
        greet(message, i18n.getMessage(SOURCE_NO_IDENTIFIED));
    }

    @Override
    public void greet(String message, String fromName) {
        LOG.info(i18n.getMessage(RECIVED_GREETING, fromName, message));
    }
}
