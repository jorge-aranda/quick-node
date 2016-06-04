
package es.jaranda.quick.node.batch.service;

public interface GreetingService {
    
    /**
     * Puts a message into application log from 'no identified' sender
     * @param message Message recieved
     */
    void greet(String message);
    
    /**
     * Puts a message into application log from a sender
     * 
     * @param message Message recieved
     * @param fromName Name of the sender
     */
    void greet(String message, String fromName);
}
