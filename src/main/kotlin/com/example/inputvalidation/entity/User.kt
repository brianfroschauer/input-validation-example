package com.example.inputvalidation.entity

import javax.persistence.*

@Entity
data class User (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "first_name", nullable = false)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false)
    var lastName: String = "",

    @Column(name = "username", nullable = false, unique = true)
    val username: String = "",

    @Column(name = "password", nullable = false)
    val password: String = ""
)
