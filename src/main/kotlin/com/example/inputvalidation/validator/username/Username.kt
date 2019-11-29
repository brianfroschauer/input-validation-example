package com.example.inputvalidation.validator.username

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [UsernameValidator::class])
@Target(allowedTargets = [FUNCTION, FIELD, ANNOTATION_CLASS, CONSTRUCTOR, VALUE_PARAMETER, TYPE_PARAMETER])
@Retention(AnnotationRetention.RUNTIME)
annotation class Username(
        val message: String = "Invalid username",
        val groups: Array<KClass<out Any>> = [],
        val payload: Array<KClass<out Payload>> = []
)