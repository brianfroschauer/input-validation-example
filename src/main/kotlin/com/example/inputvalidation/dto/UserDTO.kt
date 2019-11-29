package com.example.inputvalidation.dto

import com.example.inputvalidation.entity.User
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class UserDTO(
        val id: Long,
        val firstName: String,
        val lastName: String,
        @Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,6}$")
        val email: String
)

data class CreateUserDTO(
        @field:Size(min = 2, max = 20)
        val firstName: String,
        @field:Size(min = 2, max = 20)
        val lastName: String,
        @Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,6}$")
        val email: String,
        @field:Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
        val password: String
)

data class UpdateUserDTO(
        @field:Size(min = 2, max = 20)
        val firstName: String,
        @field:Size(min = 2, max = 20)
        val lastName: String
)

fun User.toUserDTO() = UserDTO(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email
)

fun CreateUserDTO.toUser() = User(
        firstName = firstName,
        lastName = lastName,
        email = email,
        password = password
)

fun UpdateUserDTO.toUser() = User(
        firstName = firstName,
        lastName = lastName
)
