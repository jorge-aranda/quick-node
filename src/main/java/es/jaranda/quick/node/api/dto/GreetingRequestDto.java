

package es.jaranda.quick.node.api.dto;

// XXX In a future, this dto will be disappear and it will be used a common structure for all jobs: {'jobName':'greet', 'jobParameters':{'message':'hello'}}

import java.io.Serializable;

public class GreetingRequestDto implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
