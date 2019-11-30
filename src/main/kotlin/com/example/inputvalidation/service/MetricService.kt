package com.example.inputvalidation.service

import com.example.inputvalidation.entity.Metric

interface MetricService {

    fun findAll(): List<Metric>

    fun findOne(name: String): Metric

    fun average(name: String): Long

    fun create(name: String, time: Long): Metric

    fun delete(name: String)
}