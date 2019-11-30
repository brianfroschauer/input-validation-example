package com.example.inputvalidation.validator.password

import com.example.inputvalidation.validator.Validator
import javax.validation.ConstraintValidatorContext

class PasswordValidator : Validator<Password, CharSequence>() {

    override var name = "password"

    override fun matches(value: CharSequence, context: ConstraintValidatorContext?): Boolean {
        val pattern = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+\$).{8,}\$")
        return pattern.matches(value)
    }
}