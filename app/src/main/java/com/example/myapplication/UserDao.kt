package com.example.myapplication
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface userDao{
    @insert
    suspend fun insertuser (user: user)

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun getUserByCredentials(username: String, password: String): user?

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getUserByUsername(username: String): user?
}