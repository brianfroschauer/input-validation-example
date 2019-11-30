package com.example.inputvalidation.validator.age

import com.example.inputvalidation.validator.Validator
import javax.validation.ConstraintValidatorContext

class AgeValidator : Validator<Age, Int>() {

    override var name = "age"

    override fun matches(value: Int, context: ConstraintValidatorContext?): Boolean {
        return value in 18..99
    }
}