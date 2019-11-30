package com.example.inputvalidation.repository

import com.example.inputvalidation.entity.Metric
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MetricRepository : JpaRepository<Metric, Long> {

    fun findFirstByName(name: String): Optional<Metric>
}