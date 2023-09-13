package com.example.restspringkotlin.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}