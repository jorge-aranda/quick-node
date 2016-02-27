
package es.jaranda.quick.node.demo.controller;

import es.jaranda.quick.node.batch.service.GreetingService;
import es.jaranda.quick.node.demo.dto.DemoResponseDto;
import es.jaranda.quick.node.util.I18nHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import static es.jaranda.quick.node.constants.DemoConstants.*;
import static es.jaranda.quick.node.constans.i18n.DemoI18nConstants.*;
import static es.jaranda.quick.node.constans.i18n.ErrorsI18nConstants.*;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// XXX This class is only for demo purposes and will be removed in future versions

/**
 * This controller greets into logger
 */
@Controller
@RequestMapping(REQUEST_MAPPING_URL)
public class DemoController {

    private static final Logger LOG = Logger.getLogger(DemoController.class);
    
    @Autowired
    private I18nHelper i18n;
    
    @Autowired
    private GreetingService greetingService;
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody DemoResponseDto greet(
            HttpSession session,
            @RequestParam(value=MESSAGE_PARAM, required=true) String message
        ) {
        
        boolean success;
        
        try
        {
            greetingService.greet(message, session.getId());
            success = true;
        } catch (Exception ex) {
            LOG.error(i18n.getMessage(ERROR_PROCESSING_MESSAGE), ex);
            success = false;
        }
        
        // Generate response to client
        DemoResponseDto response = new DemoResponseDto();
        response.setStatus(success);
        
        return response;
    }
}
