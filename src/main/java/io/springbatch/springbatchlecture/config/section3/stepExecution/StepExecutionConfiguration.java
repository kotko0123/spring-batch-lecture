//package io.springbatch.springbatchlecture.config.section3.stepExecution;
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
//public class StepExecutionConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job-StepExecution1")
//      .start(step1())
//      .next(step2())
//      .next(step3())
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1-StepExecution")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step1-StepExecution");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2-StepExecution")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2-StepExecution");
////        throw new RuntimeException("test error");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step3() {
//    return stepBuilderFactory.get("step3-StepExecution")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step3-StepExecution");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
