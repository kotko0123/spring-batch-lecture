//package io.springbatch.springbatchlecture.config.section4.jobBuilderFactory;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowBuilder;
//import org.springframework.batch.core.job.flow.Flow;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class SimpleJobAndFlowJobConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
////  @Bean
////  public Job job1() {
////    return jobBuilderFactory.get("job1-jobBuilderFactory")
////      .start(step1())
////      .next(step2())
////      .build();
////  }
//
//  @Bean
//  public Job job2() {
//    return jobBuilderFactory.get("job2-jobBuilderFactory")
//      .start(flow())
//      .next(step5())
//      .end()
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1-jobBuilderFactory")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step1-jobBuilderFactory");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2-jobBuilderFactory")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2-jobBuilderFactory");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Flow flow() {
//    FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flow"); // step 과 동일한 레벨이다.
//    flowBuilder.start(step3())
//      .next(step4())
//      .end();
//    return flowBuilder.build();
//  }
//
//  @Bean
//  public Step step3() {
//    return stepBuilderFactory.get("step3-jobBuilderFactory")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step3-jobBuilderFactory");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step4() {
//    return stepBuilderFactory.get("step4-jobBuilderFactory")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step4-jobBuilderFactory");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step5() {
//    return stepBuilderFactory.get("step5-jobBuilderFactory")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step5-jobBuilderFactory");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
