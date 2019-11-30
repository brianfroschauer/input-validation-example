package com.example.inputvalidation.dto

import com.example.inputvalidation.entity.Metric

data class MetricDTO(
        val id: Long,
        val name: String,
        val samples: Int,
        val time: Long
)

data class MetricAvgDTO(
    val name: String,
    val avg: Long
)

fun Metric.toMetricDTO() = MetricDTO(
        id = id,
        name = name,
        samples = samples,
        time = time
)