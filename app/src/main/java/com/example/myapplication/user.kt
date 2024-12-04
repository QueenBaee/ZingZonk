package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey
class user {
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: long= 0,

    val username:String,
    val password: String
)
}