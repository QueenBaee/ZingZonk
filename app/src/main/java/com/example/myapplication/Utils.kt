package com.example.myapplication
import java.security.MessageDigest
class Utils {
    fun hashPassword(password:String): String{
        val bytes = password.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val hashedBytes = md.digest(bytes)
        return hashedBytes.joinToString(""){"%02x".format(it)}
    }
}