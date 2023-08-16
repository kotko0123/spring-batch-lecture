package io.springbatch.springbatchlecture.config.jobParameters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JobParameterConfiguration {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job job() {
    return jobBuilderFactory.get("job-JobParameter")
      .start(step1())
      .next(step2())
      .build();
  }

  @Bean
  public Step step1() {
    return stepBuilderFactory.get("step1-JobParameter")
      .tasklet((contribution, chunkContext) -> {
        log.info("### step1-JobParameter");
        JobParameters jobParameters = contribution.getStepExecution().getJobExecution().getJobParameters();
        jobParameters.getParameters().forEach((key, params) -> {
          System.out.println(String.format("(%s) %s=%s", params.getType(), key, params.getValue()));
        });
        return RepeatStatus.FINISHED;
      })
      .build();
  }

  @Bean
  public Step step2() {
    return stepBuilderFactory.get("step2-JobParameter")
      .tasklet((contribution, chunkContext) -> {
        log.info("### step2-JobParameter");
        Map<String, Object> jobParameters = chunkContext.getStepContext().getJobParameters();
        jobParameters.forEach((key, value) -> {
          System.out.println(String.format("%s=%s", key, value));
        });
        return RepeatStatus.FINISHED;
      })
      .build();
  }
}
