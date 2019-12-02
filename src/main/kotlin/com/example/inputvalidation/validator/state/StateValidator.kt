package com.example.inputvalidation.validator.state

import com.example.inputvalidation.validator.Patterns
import com.example.inputvalidation.validator.Validator
import javax.validation.ConstraintValidatorContext

class StateValidator : Validator<State, CharSequence>() {

    override var name = "state"

    override fun matches(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex(Patterns.STATE)
        return pattern.matches(value)
    }
}