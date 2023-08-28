//package io.springbatch.springbatchlecture.config.section3.jobInstance;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
///**
// * jobLauncher로 실행시키기 위해서는 yml에 spring.batch.job.enable=false 로 설정해줘야 자동 실행이 안됨.
// */
//@RequiredArgsConstructor
//@Component
//public class JobRunner implements ApplicationRunner {
//
//  private final JobLauncher jobLauncher;
//  private final Job job;
//
//  @Override
//  public void run(ApplicationArguments args) throws Exception {
//
//    JobParameters jobParameters = new JobParametersBuilder()
//      .addString("name", "user2")
//      .toJobParameters();
//
//    jobLauncher.run(job, jobParameters);
//  }
//}
