package com.example.inputvalidation.validator.password

import com.example.inputvalidation.validator.Patterns
import com.example.inputvalidation.validator.Validator
import javax.validation.ConstraintValidatorContext

class PasswordValidator : Validator<Password, CharSequence>() {

    override var name = "password"

    override fun matches(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex(Patterns.PASSWORD)
        return pattern.matches(value)
    }
}