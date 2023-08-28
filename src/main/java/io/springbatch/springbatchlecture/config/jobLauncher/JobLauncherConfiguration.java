//package io.springbatch.springbatchlecture.config.jobLauncher;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Web 으로 실행 시키기 위해서 yml에 spring.batch.job.enable=false 로 설정 해줘야 자동 실행이 안됨.
// */
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class JobLauncherConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job-JobLauncher")
//      .start(step1())
//      .next(step2())
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1-JobLauncher")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step1-JobLauncher");
//        Thread.sleep(3000);
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2-JobLauncher")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2-JobLauncher");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
