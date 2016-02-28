
package es.jaranda.quick.node.api.controller;

import static es.jaranda.quick.node.api.constants.UrlMappingConstants.*;
import static es.jaranda.quick.utils.QuickDateUtils.*;
import es.jaranda.quick.node.batch.config.BatchContext;
import es.jaranda.quick.node.batch.job.GreetingJobContext;
import javax.servlet.http.HttpSession;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.
        JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.
        JobInstanceAlreadyCompleteException;
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
    public @ResponseBody ExitStatus greet(HttpSession session) throws 
            JobExecutionAlreadyRunningException, 
            JobRestartException, 
            JobInstanceAlreadyCompleteException, 
            JobParametersInvalidException {
        
        JobParametersBuilder jpBuilder = new JobParametersBuilder();

        jpBuilder.addLong(BatchContext.TIMESTAMP_PARAMETER, timestamp());
        // FIXME use json parameter
        jpBuilder.addString(GreetingJobContext.MESSAGE_PARAMETER, "test");
        jpBuilder.addString(
                GreetingJobContext.FROM_NAME_PARAMETER, session.getId()
        );
        
        
        return jobLauncher.run(greetingJob, jpBuilder.toJobParameters())
                .getExitStatus();
    }
}
