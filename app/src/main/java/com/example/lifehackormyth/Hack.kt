package com.example.lifehackormyth

// Represents one life hack question
data class Hack(
    val statement: String,
    val isTrue: Boolean,
    val explanation: String
)