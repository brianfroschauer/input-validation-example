package com.example.inputvalidation.dto

import com.example.inputvalidation.entity.User
import com.example.inputvalidation.validator.age.Age
import com.example.inputvalidation.validator.name.Name
import com.example.inputvalidation.validator.password.Password
import com.example.inputvalidation.validator.username.Username
import javax.validation.constraints.NotNull

data class UserDTO(
        val id: Long,
        val firstName: String,
        val lastName: String,
        val username: String,
        val age: Int
)

data class CreateUserDTO(
        @field:NotNull @field:Name
        val firstName: String,
        @field:NotNull @field:Name
        val lastName: String,
        @field:NotNull @field:Username
        val username: String,
        @field:NotNull @field:Password
        val password: String,
        @field:NotNull @field:Age
        val age: Int
)

data class UpdateUserDTO(
        @field:NotNull @field:Name
        val firstName: String,
        @field:NotNull @field:Name
        val lastName: String,
        @field:NotNull @field:Age
        val age: Int
)

fun User.toUserDTO() = UserDTO(
        id = id,
        firstName = firstName,
        lastName = lastName,
        username = username,
        age = age
)

fun CreateUserDTO.toUser() = User(
        firstName = firstName,
        lastName = lastName,
        username = username,
        password = password,
        age = age
)

fun UpdateUserDTO.toUser() = User(
        firstName = firstName,
        lastName = lastName,
        age = age
)
