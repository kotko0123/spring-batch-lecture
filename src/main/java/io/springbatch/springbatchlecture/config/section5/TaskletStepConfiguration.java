//package io.springbatch.springbatchlecture.config.section5;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.item.*;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class TaskletStepConfiguration {
//
//  private final JobBuilderFactory jobBuilderFactory;
//  private final StepBuilderFactory stepBuilderFactory;
//
//  @Bean
//  public Job job() {
//    return jobBuilderFactory.get("job1")
//      .incrementer(new RunIdIncrementer())
////      .start(taskStep())
//      .start(chunkStep())
//      .next(customStep())
//      .build();
//  }
//
//  @Bean
//  public Step taskStep() {
//    return stepBuilderFactory.get("taskStep")
//      .tasklet(new Tasklet() {
//        @Override
//        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//          log.info("### taskStep was executed.");
//          return RepeatStatus.FINISHED;
//        }
//      })
//      .build();
//  }
//
//  @Bean
//  public Step chunkStep() {
//    return stepBuilderFactory.get("chunkStep")
//      .<String,String>chunk(3)
//      .reader(new ListItemReader<>(IntStream.range(0, 10).mapToObj(i -> "item"+i).collect(Collectors.toList())))
//      .processor(new ItemProcessor<String, String>() {
//        @Override
//        public String process(String item) throws Exception {
//          return item.toUpperCase();
//        }
//      })
//      .writer(new ItemWriter<String>() {
//        @Override
//        public void write(List<? extends String> items) throws Exception {
//          items.forEach(log::info);
//        }
//      })
//      .build();
//  }
//
//  @Bean
//  public Step customStep() {
//    return stepBuilderFactory.get("customStep")
//      .tasklet(new CustomTasklet())
//      .build();
//  }
//}
