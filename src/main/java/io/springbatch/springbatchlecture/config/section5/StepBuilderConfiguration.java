//package io.springbatch.springbatchlecture.config.section5;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowBuilder;
//import org.springframework.batch.core.job.flow.Flow;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.*;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class StepBuilderConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job")
//      .incrementer(new RunIdIncrementer())
//      .start(step1())
//      .next(step2())
//      .next(step3())
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
//      .<String,String>chunk(3)
//      .reader(new ItemReader<String>() {
//        @Override
//        public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//          return null;
//        }
//      })
//      .processor(new ItemProcessor<String, String>() {
//        @Override
//        public String process(String s) throws Exception {
//          return null;
//        }
//      })
//      .writer(new ItemWriter<String>() {
//        @Override
//        public void write(List<? extends String> list) throws Exception {
//
//        }
//      })
//      .build();
//  }
//
//  @Bean
//  public Step step3() {
//    return stepBuilderFactory.get("step3")
//      .partitioner(step1())
//      .gridSize(2)
//      .build();
//  }
//
//  @Bean
//  public Step step4() {
//    return stepBuilderFactory.get("step4")
//      .job(job()) // Step 안에서 Job을 실행시킨다.
//      .build();
//  }
//
//  @Bean
//  public Step step5() {
//    return stepBuilderFactory.get("step5")
//      .flow(flow()) // Step 안에서 Flow를 실행시킨다.
//      .build();
//  }
//
//  @Bean
//  public Flow flow() {
//    FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flow");
//    flowBuilder.start(step2()).end();
//    return flowBuilder.build();
//  }
//
//}
