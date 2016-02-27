
package es.jaranda.quick.node.api.controller;

import static es.jaranda.quick.node.api.constants.UrlMappingConstants.*;
import es.jaranda.quick.node.batch.job.GreetingJobContext;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// XXX In a future, this controller will be disappear. To launch job you will do POST to /job {'jobName':'greet'}

@Controller
@RequestMapping(GREETING_URL_MAPPING)
public class GreetingController {
    
    private static final Logger LOG = 
            LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private JobLauncher jobLauncher;
    
    // TODO this is the future 'way' to implement Jobs?
    @Autowired
    @Qualifier(GreetingJobContext.GREETING_JOB)
    private Job greetingJob;
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody boolean greet() {
        boolean success;
        
        try
        {
            JobExecution jobExecution = 
                    jobLauncher.run(greetingJob, new JobParameters());
            success = jobExecution.getExitStatus().equals(ExitStatus.COMPLETED);
            
        } catch (JobExecutionAlreadyRunningException | 
                JobRestartException | JobInstanceAlreadyCompleteException | 
                JobParametersInvalidException ex) {
            LOG.error("", ex);
            success = false;
        }
        
        return success;
    }
}
