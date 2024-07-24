package jjfactory.data_processing.exchange

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.core.step.tasklet.TaskletStep
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExchangeBatch {

    @Bean
    fun exchangeJob(jobRepository: JobRepository): Job {
        return JobBuilder("exchangeJob", jobRepository)
            .start(exchangeStep(jobRepository))
            .build()

    }

    @Bean
    fun exchangeStep(jobRepository: JobRepository): Step {
        return StepBuilder("exchangeStep", jobRepository)
            .tasklet { a,b -> RepeatStatus.FINISHED }
            .build()
    }

}