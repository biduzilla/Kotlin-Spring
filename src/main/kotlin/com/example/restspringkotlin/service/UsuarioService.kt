package com.example.restspringkotlin.service

import com.example.restspringkotlin.model.Usuario
import com.example.restspringkotlin.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val repository: UsuarioRepository) {

    fun buscaPorId(id: Long): Usuario {
        return repository.getReferenceById(id)
    }
}