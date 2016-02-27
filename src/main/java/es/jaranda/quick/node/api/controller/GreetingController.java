
package es.jaranda.quick.node.api.controller;

import static es.jaranda.quick.node.api.constants.UrlMappingConstants.*;
import es.jaranda.quick.node.batch.job.GreetingJobContext;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// XXX In a future, this controller will be disappear. To launch job you will do POST to /job {'jobName':'greet', 'jobParameters':{}}

@Controller
@RequestMapping(GREETING_URL_MAPPING)
public class GreetingController {

    @Autowired
    private JobLauncher jobLauncher;
    
    @Autowired
    @Qualifier(GreetingJobContext.GREETING_JOB)
    private Job greetingJob;
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody ExitStatus greet() throws 
            JobExecutionAlreadyRunningException, 
            JobRestartException, 
            JobInstanceAlreadyCompleteException, 
            JobParametersInvalidException {
        
        return jobLauncher.run(greetingJob, new JobParameters())
                .getExitStatus();
    }
}
