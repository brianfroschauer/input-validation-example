package com.example.inputvalidation.controller

import com.example.inputvalidation.dto.MetricAvgDTO
import com.example.inputvalidation.dto.MetricDTO
import com.example.inputvalidation.dto.toMetricDTO
import com.example.inputvalidation.service.MetricService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("metrics")
class MetricController(private val service: MetricService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<MetricDTO>> {
        val metrics = service.findAll().map { metric -> metric.toMetricDTO() }
        return ResponseEntity.ok(metrics)
    }

    @GetMapping("{name}")
    fun findOne(@PathVariable("name") name: String): ResponseEntity<MetricDTO> {
        val metric = service.findOne(name)
        return ResponseEntity.ok(metric.toMetricDTO())
    }

    @GetMapping("{name}/average")
    fun average(@PathVariable("name") name: String): ResponseEntity<MetricAvgDTO> {
        val average = service.average(name)
        return ResponseEntity.ok(MetricAvgDTO(name, average))
    }
}