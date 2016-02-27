
package es.jaranda.quick.node.batch.tasklet;

import es.jaranda.quick.node.batch.service.GreetingService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This tasklet print into App logger a message recived into a parameter
 */
@Component
public class GreetTasklet implements Tasklet {
    
    @Autowired
    private GreetingService greetingService;
    
    @Override
    public RepeatStatus execute(StepContribution contribution,
                    ChunkContext context) {
        // FIXME Pending to implement action
        throw new UnsupportedOperationException();
//        return RepeatStatus.FINISHED;
    }
    
}
