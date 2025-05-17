package dev.abhinav.auth.domain

interface PatternValidator {

    fun matches(value: String) : Boolean
}