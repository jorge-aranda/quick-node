

package es.jaranda.quick.node.api.dto;

// XXX In a future, this dto will be disappear and it will be used a common structure for all jobs: {'jobName':'greet', 'jobParameters':{'message':'hello'}}

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class GreetingRequestDto implements Serializable {
    
    private static final int MESSAGE_MAX_LENGTH = 250;
    
    @NotNull
    @Max(MESSAGE_MAX_LENGTH)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
