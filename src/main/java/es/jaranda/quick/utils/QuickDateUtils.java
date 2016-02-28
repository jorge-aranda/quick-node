
package es.jaranda.quick.utils;

import java.util.Date;


/**
 * Utility class to manage dates
 */
public class QuickDateUtils {
    
    private QuickDateUtils() {
        // no instanciable
    }
    
    /**
     * Get server time Date instance
     * @return Server time Date instance
     */
    public static Date now() {
        return new Date();
    }
    
    /**
     * Get era time in milliseconds from current time
     * @return era time in milliseconds from current time
     */
    public static long timestamp() {
        return now().getTime();
    }
}
