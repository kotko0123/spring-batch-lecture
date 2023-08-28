//package io.springbatch.springbatchlecture.config.section3.jobRepository;
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
//public class JobRepositoryConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//  private final JobRepositoryListener jobRepositoryListener;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("batchJob")
//      .start(step1())
//      .next(step2())
//      .listener(jobRepositoryListener)
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1-JobRepository")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step1-JobRepository");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2-JobRepository")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2-JobRepository");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
