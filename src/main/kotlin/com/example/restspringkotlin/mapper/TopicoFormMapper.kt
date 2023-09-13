package com.example.restspringkotlin.mapper

import com.example.restspringkotlin.dto.NovoTopicoForm
import com.example.restspringkotlin.model.Topico
import com.example.restspringkotlin.service.CursoService
import com.example.restspringkotlin.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) : Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscaPorId(t.idAutor)
        )
    }
}