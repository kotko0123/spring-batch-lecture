//package io.springbatch.springbatchlecture.config.section4.increment;
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
//public class IncrementJobConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job")
//      .start(step1())
//      .next(step2())
//      // custom
////      .incrementer(new CustomJobParametersIncrement())
//      // spring 에서 제공
//      .incrementer(new RunIdIncrementer())
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step1");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
