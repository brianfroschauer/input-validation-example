package com.example.inputvalidation.validator.username

import com.example.inputvalidation.validator.Validator
import javax.validation.ConstraintValidatorContext

class UsernameValidator : Validator<Username, CharSequence>() {

    override var name = "username"

    override fun matches(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex("^(?=.{8,20}\$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])\$")
        return pattern.matches(value)
    }
}
