package com.example.inputvalidation.validator.name

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class NameValidator : ConstraintValidator<Name, CharSequence> {

    override fun isValid(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex("^([a-zA-Z]+[,.]?[ ]?|[a-z]+['-]?)+\$")
        return pattern.matches(value)
    }
}