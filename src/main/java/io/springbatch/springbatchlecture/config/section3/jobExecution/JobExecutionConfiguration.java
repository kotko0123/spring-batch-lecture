//package io.springbatch.springbatchlecture.config.section3.jobExecution;
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
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class JobExecutionConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job-JobExecution")
//      .start(step1())
//      .next(step2())
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1-JobExecution")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step1-JobExecution");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2-JobExecution")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2-JobExecution");
////        throw new RuntimeException("error");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
