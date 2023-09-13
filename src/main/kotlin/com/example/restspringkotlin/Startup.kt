package com.example.restspringkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class Startup

fun main(args: Array<String>) {
	runApplication<Startup>(*args)
}
