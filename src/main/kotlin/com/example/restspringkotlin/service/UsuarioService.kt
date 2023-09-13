package com.example.restspringkotlin.service

import com.example.restspringkotlin.model.Usuario
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class UsuarioService(private var usuarios: List<Usuario>) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Toddy",
            email = "email@email.com"
        )
        usuarios = listOf(usuario)
    }

    fun buscaPorId(id: Long): Usuario {
        return usuarios.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}