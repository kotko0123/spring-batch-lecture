//package io.springbatch.springbatchlecture.config.section5;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.job.DefaultJobParametersExtractor;
//import org.springframework.batch.core.step.job.JobParametersExtractor;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class JobStepConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job parentJob() {
//    return jobBuilderFactory.get("parentJob")
//      .incrementer(new RunIdIncrementer())
//      .start(jobStep(null))
//      .next(step2())
//      .build();
//  }
//
//  @Bean
//  public Step jobStep(JobLauncher jobLauncher) { // jobLauncher DI 받음
//    return stepBuilderFactory.get("jobStep")
//      .job(childJob())
//      .launcher(jobLauncher)
//      .parametersExtractor(jobParameterExtractor())
//      .listener(new StepExecutionListener() {
//        @Override
//        public void beforeStep(StepExecution stepExecution) {
//          stepExecution.getExecutionContext().putString("name", "user1");
//        }
//
//        @Override
//        public ExitStatus afterStep(StepExecution stepExecution) {
//          return null;
//        }
//      })
//      .build();
//  }
//
//  // bean 일 필요 없음.
//  private JobParametersExtractor jobParameterExtractor() {
//    // ExecuteContext 안에 있는 JobParameter Key 를 가져 올 수 있음.
//    DefaultJobParametersExtractor extractor = new DefaultJobParametersExtractor();
//    extractor.setKeys(new String[]{"name"}); // 그 Key 임.
//    return extractor;
//  }
//
//  @Bean
//  public Job childJob() {
//    return jobBuilderFactory.get("childJob")
//      .incrementer(new RunIdIncrementer())
//      .start(step1())
//      .build();
//  }
//
//  @Bean
//  public Step step1() {
//    return stepBuilderFactory.get("step1")
//      .tasklet(new Tasklet() {
//        @Override
//        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//          log.info("### step1 was executed.");
//          return RepeatStatus.FINISHED;
//        }
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step2() {
//    return stepBuilderFactory.get("step2")
//      .tasklet(new Tasklet() {
//        @Override
//        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//          log.info("### step2 was executed.");
//          return RepeatStatus.FINISHED;
//        }
//      })
//      .build();
//  }
//
//}
