//package io.springbatch.springbatchlecture.config.section4.preventRestart;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.*;
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
//public class PreventRestartJobConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job")
//      .start(step1())
//      .next(step2())
//      .preventRestart() // 실패한 경우에도 이 작업 실행을 다시 시작하지 못하도록 플래그를 설정합니다.
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
////        throw new RuntimeException("step2 was failed");
//        log.info("### step2");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
