package com.example.restspringkotlin.service

import com.example.restspringkotlin.exception.NotFoundException
import com.example.restspringkotlin.model.Curso
import com.example.restspringkotlin.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getReferenceById(id)
    }
}