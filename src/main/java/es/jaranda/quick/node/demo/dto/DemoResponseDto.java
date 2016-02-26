
package es.jaranda.quick.node.demo.dto;

import java.io.Serializable;


// XXX This class is only for demo purposes and will be removed in future versions

public class DemoResponseDto implements Serializable {
    
    private boolean status;
    
    public boolean getStatus()
    {
        return status;
    }
    
    public void setStatus(boolean status)
    {
        this.status = status;
    }
}
