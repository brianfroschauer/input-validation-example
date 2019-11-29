package com.example.inputvalidation.exception

import java.util.*

class ApiError(val timestamp: Date, val status: Int, val message: String, val path: String)
