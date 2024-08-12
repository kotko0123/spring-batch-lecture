package io.springbatch.springbatchlecture.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ChunkJobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job chunkJob() {
    return jobBuilderFactory.get("chunkJob")
      .start(chunkStep1())
//      .next(chunkStep2())
      .build();
  }

  @Bean
  public Step chunkStep1() {
    return stepBuilderFactory.get("chunkStep1")
      .<String, String>chunk(10)
      .reader(itemReader())
      .processor(itemProcessor())
      .writer(itemWriter())
      .build();
  }

  private ItemReader<String> itemReader() {
    return new ListItemReader<>(getItems());
  }

  private ItemProcessor<String, String> itemProcessor() {
    return item -> item + " now processor!!";
  }

  private ItemWriter<String> itemWriter() {
    return items -> log.info("### writer : " + items);
  }

  private List<String> getItems() {
    return IntStream.range(1, 101)
      .mapToObj(i -> "No. " + i)
      .collect(Collectors.toList());
  }

//  @Bean
//  public Step chunkStep2() {
//    return stepBuilderFactory.get("chunkStep2")
//      .tasklet((contribution, chunkContext) -> {
//        log.info("### chunk Spring Batch 222");
//        return RepeatStatus.FINISHED;
//      })
//      .build();
//  }
}
