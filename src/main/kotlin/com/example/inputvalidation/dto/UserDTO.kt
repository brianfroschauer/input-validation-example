package com.example.inputvalidation.dto

import com.example.inputvalidation.entity.User
import com.example.inputvalidation.validator.name.Name
import com.example.inputvalidation.validator.password.Password
import com.example.inputvalidation.validator.username.Username

data class UserDTO(
        val id: Long,
        val firstName: String,
        val lastName: String,
        val username: String
)

data class CreateUserDTO(
        @field:Name
        val firstName: String,
        @field:Name
        val lastName: String,
        @field:Username
        val username: String,
        @field:Password
        val password: String
)

data class UpdateUserDTO(
        @field:Name
        val firstName: String,
        @field:Name
        val lastName: String
)

fun User.toUserDTO() = UserDTO(
        id = id,
        firstName = firstName,
        lastName = lastName,
        username = username
)

fun CreateUserDTO.toUser() = User(
        firstName = firstName,
        lastName = lastName,
        username = username,
        password = password
)

fun UpdateUserDTO.toUser() = User(
        firstName = firstName,
        lastName = lastName
)
