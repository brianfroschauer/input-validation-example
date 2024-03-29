package com.example.inputvalidation.validator.username

import com.example.inputvalidation.validator.Patterns
import com.example.inputvalidation.validator.Validator
import javax.validation.ConstraintValidatorContext

class UsernameValidator : Validator<Username, CharSequence>() {

    override var name = "username"

    override fun matches(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex(Patterns.USERNAME)
        return pattern.matches(value)
    }
}
