//package io.springbatch.springbatchlecture.config.jobLauncher.web;
//
//import io.springbatch.springbatchlecture.config.jobLauncher.web.dto.Member;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.launch.support.SimpleJobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//
///**
// * Web 으로 실행 하려면 yml에 spring.batch.job.enable=false 로 설정 해줘야 자동 실행이 안됨.
// * pom.xml 에 'spring-boot-starter-web' 추가해야함.
// */
//@RestController
//public class JobLauncherController {
//
//  @Autowired
//  private Job job;
//
//  @Autowired
//  private JobLauncher jobLauncher;
//
//  @Autowired
//  private BasicBatchConfigurer basicBatchConfigurer;
//
//  @PostMapping("batch/async")
//  public String launch(@RequestBody Member member) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
//
//    JobParameters jobParameters = new JobParametersBuilder()
//      .addString("id", member.getId())
//      .addDate("date", new Date())
//      .toJobParameters();
//
//    SimpleJobLauncher jobLauncher = (SimpleJobLauncher) basicBatchConfigurer.getJobLauncher();
//    jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
//    JobExecution jobExecution = jobLauncher.run(job, jobParameters);
//
//    return String.format("batch completed. (ExitStatus: %s)", jobExecution.getExitStatus().getExitCode());
//  }
//
//  @PostMapping("batch")
//  public String launchSync(@RequestBody Member member) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
//
//    JobParameters jobParameters = new JobParametersBuilder()
//      .addString("id", member.getId())
//      .addDate("date", new Date())
//      .toJobParameters();
//
//    JobExecution jobExecution = this.jobLauncher.run(job, jobParameters);
//
//    return String.format("batch completed. (ExitStatus: %s)", jobExecution.getExitStatus().getExitCode());
//  }
//}
