//package io.springbatch.springbatchlecture.config.section4.multiJob;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class JobConfiguration2 {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job2() {
//    return jobBuilderFactory.get("batchJob2")
//      .incrementer(new RunIdIncrementer())
//      .start(step2_1())
//      .next(step2_2())
//      .build();
//  }
//
//  @Bean
//  public Step step2_1() {
//    return stepBuilderFactory.get("step2-1")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2-1");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2_2() {
//    return stepBuilderFactory.get("step2-2")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2-2");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
