//package io.springbatch.springbatchlecture.config.section3.stepContribution;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class StepContributionConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job-StepContribution")
//      .start(step1())
//      .next(step2())
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1-StepContribution")
//      .tasklet(new Tasklet() {
//        @Override
//        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//          log.info("### step1-StepContribution");
//          System.out.println(contribution);
//          return RepeatStatus.FINISHED;
//        }
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2-StepContribution")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2-StepContribution");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
