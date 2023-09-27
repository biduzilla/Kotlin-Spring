package com.example.restspringkotlin.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

interface JwtService {
    fun extractUserName(token: String): String
    fun generateToken(userDetails: UserDetails): String
    fun isTokenValid(token: String): Boolean
}