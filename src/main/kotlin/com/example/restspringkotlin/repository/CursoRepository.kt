package com.example.restspringkotlin.repository

import com.example.restspringkotlin.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository:JpaRepository<Curso, Long>{

}