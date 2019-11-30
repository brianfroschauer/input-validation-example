package com.example.inputvalidation.entity

import javax.persistence.*

@Entity
data class Metric(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "name", nullable = false, unique = true)
        val name: String = "",

        @Column(name = "samples", nullable = false)
        var samples: Int = 0,

        @Column(name = "time", nullable = false)
        var time: Long = 0
)