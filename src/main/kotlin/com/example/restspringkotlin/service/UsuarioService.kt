package com.example.restspringkotlin.service

import com.example.restspringkotlin.model.Usuario
import com.example.restspringkotlin.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UsuarioService(private val repository: UsuarioRepository) : UserDetailsService {

    fun buscaPorId(id: Long): Usuario {
        return repository.getReferenceById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = repository.findByEmail(username) ?: throw RuntimeException()

        return UserDetail(usuario)
    }
}