//package io.springbatch.springbatchlecture.config.section3.jobParameters;
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
//import java.util.Date;
//
///**
// * jobLauncher 로 실행 시키기 위해서 yml에 spring.batch.job.enable=false 로 설정 해줘야 자동 실행이 안됨.
// *
// * 어플리케이션 싫행 시 주입하는 방법(JobParameterRunner 는 Bean 등록하지 않아야 됨.)
// * java -jar spring-batch-lecture-0.0.1-SNAPSHOT.jar name=user1
// */
//@RequiredArgsConstructor
//@Component
//public class JobParameterRunner implements ApplicationRunner {
//
//  private final JobLauncher jobLauncher;
//  private final Job job;
//
//  @Override
//  public void run(ApplicationArguments args) throws Exception {
//
//    JobParameters jobParameters = new JobParametersBuilder()
//      .addString("name", "parameters1")
//      .addLong("seq", 1L)
//      .addDate("date", new Date())
//      .addDouble("age", 16.5)
//      .toJobParameters();
//
//    jobLauncher.run(job, jobParameters);
//  }
//}
