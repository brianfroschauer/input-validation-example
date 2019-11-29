package com.example.inputvalidation.validator.password

import com.example.inputvalidation.service.TimerService
import org.springframework.beans.factory.annotation.Autowired
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PasswordValidator(@Autowired private val timerService: TimerService) : ConstraintValidator<Password, CharSequence> {

    override fun isValid(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+\$).{8,}\$")
        return pattern.matches(value)
    }
}