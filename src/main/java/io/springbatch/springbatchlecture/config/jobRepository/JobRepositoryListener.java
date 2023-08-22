package io.springbatch.springbatchlecture.config.jobRepository;

import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobRepositoryListener implements JobExecutionListener {

  @Autowired
  private JobRepository jobRepository;

  @Override
  public void beforeJob(JobExecution jobExecution) {

  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    String jobName = jobExecution.getJobInstance().getJobName();

    JobParameters jobParameters = new JobParametersBuilder()
      .addString("requestDate", "20210102")
      .toJobParameters();

    JobExecution lastJobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);

    if (lastJobExecution != null) {
      JobParameters jobParameters1 = lastJobExecution.getJobParameters();
      System.out.println("jobParameters1 ::: " + jobParameters1);
      for (StepExecution stepExecution : lastJobExecution.getStepExecutions()) {
        BatchStatus status = stepExecution.getStatus();
        ExitStatus exitStatus = stepExecution.getExitStatus();
        String stepName = stepExecution.getStepName();
        System.out.println("status : " + status);
        System.out.println("exitStatus : " + exitStatus);
        System.out.println("stepName : " + stepName);
      }
    }
  }
}
