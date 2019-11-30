package com.example.inputvalidation.validator.name

import com.example.inputvalidation.validator.Validator
import javax.validation.ConstraintValidatorContext

class NameValidator : Validator<Name, CharSequence>() {

    override var name = "name"

    override fun matches(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex("^[A-Z][a-zA-Z][^#&<>\"~;\$^%{}?]{1,20}\$")
        return pattern.matches(value)
    }
}