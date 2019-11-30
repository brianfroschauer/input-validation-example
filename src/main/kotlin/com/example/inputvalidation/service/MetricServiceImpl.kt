package com.example.inputvalidation.service

import com.example.inputvalidation.entity.Metric
import com.example.inputvalidation.exception.NotFoundException
import com.example.inputvalidation.repository.MetricRepository
import org.springframework.stereotype.Service

@Service
class MetricServiceImpl(private val repository: MetricRepository) : MetricService {

    override fun findAll(): List<Metric> = repository.findAll()

    override fun findOne(name: String): Metric {
        return repository
                .findFirstByName(name)
                .orElseThrow { NotFoundException() }
    }

    override fun avg(name: String): Long {
        val metric = findOne(name)
        return metric.time / metric.samples
    }

    override fun create(name: String, time: Long): Metric {
        val metric = repository
                .findFirstByName(name)
                .orElse(Metric(name = name, time = 0, samples = 0))

        metric.samples += 1
        metric.time += time

        return repository.save(metric)
    }

    override fun delete(name: String) {
        val metric = findOne(name)
        repository.delete(metric)
    }
}