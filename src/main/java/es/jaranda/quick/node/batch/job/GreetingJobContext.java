
package es.jaranda.quick.node.batch.job;

import es.jaranda.quick.node.batch.tasklet.GreetTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingJobContext {
    
    public static final String GREETING_JOB = "greetingJob";
    public static final String GREETING_STEP = "greetingStep";
    
    @Autowired
    private JobBuilderFactory jobs;
    
    @Autowired
    private StepBuilderFactory steps;

    @Bean(name=GREETING_JOB)
    public Job greetingJob(
            GreetTasklet greetTasklet) throws Exception {
        return
            this.jobs.get(GREETING_JOB)
                    .start(
                        greetingStep(greetTasklet)
                    ).build();
    }
    
    @Bean
    protected Step greetingStep(GreetTasklet greetTasklet) throws Exception {
        return this.steps.get(GREETING_STEP).tasklet(greetTasklet).build();
    }
}
