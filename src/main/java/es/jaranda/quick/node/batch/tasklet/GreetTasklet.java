
package es.jaranda.quick.node.batch.tasklet;

import es.jaranda.quick.node.batch.config.BatchContext;
import static es.jaranda.quick.node.batch.job.GreetingJobContext.*;
import es.jaranda.quick.node.batch.service.GreetingService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This tasklet print into App logger a message recived into a parameter
 */
@Component
@StepScope
public class GreetTasklet implements Tasklet {
    
    private static final String MESSAGE_JOB_PARAMETER = 
            "#{jobParameters['" + MESSAGE_PARAMETER + "']}";

    private static final String FROM_NAME_JOB_PARAMETER = 
            "#{jobParameters['" + FROM_NAME_PARAMETER + "']}";
    
    private final String message;
    private final String fromName;
    
    @Autowired
    private GreetingService greetingService;
    
    @Autowired
    public GreetTasklet(
            @Value(MESSAGE_JOB_PARAMETER) String message,
            @Value(FROM_NAME_JOB_PARAMETER) String fromName
        ) {
        this.message = message;
        this.fromName = fromName;
    }
    
    @Override
    public RepeatStatus execute(StepContribution contribution,
                    ChunkContext context) {
        greetingService.greet(message, fromName);

        return RepeatStatus.FINISHED;
    }
    
}
