
package es.jaranda.quick.utils;

/**
 * Utility class to manage Strings
 */
public class QuickStringUtils {
    
    private static final String QUOTED_STRING_FORMAT = "'%s'";
    private static final String NULL_STRING = "(null)";
    
    private QuickStringUtils() {
        // no instanciable
    }
    
    /**
     * Returns '{item}' string if item is not null, else returns (null) string
     * @param <T>   Type of item
     * @param item  Item to be formatted '{item}' or (null)
     * @return '{item}' string if item is not null, else returns (null) string
     */
    public static<T> String toQuotedString(T item) {
        return item != null ? String.format(QUOTED_STRING_FORMAT, 
                item) : NULL_STRING;
    }
}
