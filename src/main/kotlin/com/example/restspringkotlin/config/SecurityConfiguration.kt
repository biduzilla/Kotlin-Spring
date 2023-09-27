package com.example.restspringkotlin.config

import com.example.restspringkotlin.security.JwtAuthFilter
import com.example.restspringkotlin.security.JwtService
import com.example.restspringkotlin.service.UsuarioService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.OncePerRequestFilter


@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val usuarioService: UsuarioService,
    private val jwtService: JwtService
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    @Bean
    protected fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder())
    }

    @Bean
    fun jwtFilter(): OncePerRequestFilter {
        return JwtAuthFilter(jwtService, usuarioService)
    }

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.

        authorizeHttpRequests {
            it
                .requestMatchers("/topicos")
                ?.hasAuthority("LEITURA_ESCRITA")
                ?.anyRequest()
                ?.authenticated()
        }.sessionManagement {
            it?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }.formLogin {
            it?.disable()
        }.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

}