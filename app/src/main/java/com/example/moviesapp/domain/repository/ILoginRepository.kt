package com.example.moviesapp.domain.repository

interface ILoginRepository {

    suspend fun logIn(user: String, password: String): Boolean

}