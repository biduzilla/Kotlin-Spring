package com.example.restspringkotlin.repository

import com.example.restspringkotlin.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository:JpaRepository<Usuario, Long>{

}