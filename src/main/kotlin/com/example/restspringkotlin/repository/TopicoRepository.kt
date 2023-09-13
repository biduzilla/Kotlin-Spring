package com.example.restspringkotlin.repository

import com.example.restspringkotlin.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository:JpaRepository<Topico, Long>{

}