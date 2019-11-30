package com.example.inputvalidation.validator

import com.example.inputvalidation.service.MetricService
import com.example.inputvalidation.service.TimerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@Component
abstract class Validator<A : Annotation, T> : ConstraintValidator<A, T> {

    @Autowired
    private lateinit var metricService: MetricService

    @Autowired
    private lateinit var timerService: TimerService

    abstract var name: String

    override fun isValid(value: T, context: ConstraintValidatorContext?): Boolean {
        timerService.start()
        val matches = matches(value, context)
        val time = timerService.stop()
        metricService.create(name, time)
        return matches
    }

    abstract fun matches(value: T, context: ConstraintValidatorContext?): Boolean
}