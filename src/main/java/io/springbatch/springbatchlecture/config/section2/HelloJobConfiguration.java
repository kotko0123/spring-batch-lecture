//package io.springbatch.springbatchlecture.config.section2;
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
//public class HelloJobConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job helloJob() {
//    return jobBuilderFactory.get("helloJob")
//      .start(helloStep1())
//      .next(helloStep2())
//      .build();
//  }
//
//  @Bean
//  public Step helloStep2() {
//    return stepBuilderFactory.get("helloStep2")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### Hello Spring Batch 222");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step helloStep1() {
//    return stepBuilderFactory.get("helloStep")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### Hello Spring Batch 111");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
