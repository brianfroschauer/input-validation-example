package com.example.inputvalidation.validator.name

import com.example.inputvalidation.validator.Patterns
import com.example.inputvalidation.validator.Validator
import javax.validation.ConstraintValidatorContext

class NameValidator : Validator<Name, CharSequence>() {

    override var name = "name"

    override fun matches(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex(Patterns.NAME)
        return pattern.matches(value)
    }
}