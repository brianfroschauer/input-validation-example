package com.example.inputvalidation.service

import org.springframework.stereotype.Service

@Service
class TimerServiceImpl : TimerService {

    private var start: Long = 0

    override fun start() {
        start = System.currentTimeMillis()
    }

    override fun stop(): Long = System.currentTimeMillis() - start
}