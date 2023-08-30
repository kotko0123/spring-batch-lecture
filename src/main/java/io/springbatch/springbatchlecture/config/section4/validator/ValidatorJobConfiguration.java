//package io.springbatch.springbatchlecture.config.section4.validator;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.DefaultJobParametersValidator;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class ValidatorJobConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job-validator")
//      .start(step1())
//      .next(step2())
//      .next(step3())
//      // custom
////      .validator(new CustomJobParametersValidator())
//      // default
//      .validator(new DefaultJobParametersValidator(new String[]{"name", "date"}, new String[]{"count"}))
//      // 기본 제공
////      .validator(new JobParametersValidator() {
////        @Override
////        public void validate(JobParameters parameters) throws JobParametersInvalidException {
////          System.out.println("validate params: " + parameters.getParameters());
////        }
////      })
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1-validator")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step1-validator");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2-validator")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step2-validator");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step3() {
//    return stepBuilderFactory.get("step3-validator")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### step3-validator");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
//}
