package com.example.inputvalidation.validator.username

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UsernameValidator : ConstraintValidator<Username, CharSequence> {

    override fun isValid(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex("^(?=.{8,20}\$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])\$")
        return pattern.matches(value)
    }
}
