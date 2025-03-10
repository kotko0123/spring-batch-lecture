//package io.springbatch.springbatchlecture.config.section3.executionContext;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class ExecutionContextConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//  private final ExecutionContextTasklet1 executionContextTasklet1;
//  private final ExecutionContextTasklet2 executionContextTasklet2;
//  private final ExecutionContextTasklet3 executionContextTasklet3;
//  private final ExecutionContextTasklet4 executionContextTasklet4;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job-ExecutionContext")
//      .start(step1())
//      .next(step2())
//      .next(step3())
//      .next(step4())
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1-ExecutionContext")
//      .tasklet(executionContextTasklet1)
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2-ExecutionContext")
//      .tasklet(executionContextTasklet2)
//      .build();
//  }
//
//  @Bean
//  public Step step3() {
//    return stepBuilderFactory.get("step3-ExecutionContext")
//      .tasklet(executionContextTasklet3)
//      .build();
//  }
//
//  @Bean
//  public Step step4() {
//    return stepBuilderFactory.get("step4-ExecutionContext")
//      .tasklet(executionContextTasklet4)
//      .build();
//  }
//}
