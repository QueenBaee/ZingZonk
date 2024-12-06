package com.example.myapplication
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class Utils {
    fun hashPassword(password: String): String {
        try {
            val digest = MessageDigest.getInstance("SHA-256")
            val hashBytes = digest.digest(password.toByteArray())
            val hexString = StringBuilder()
            for (b in hashBytes) {
                hexString.append(String.format("%02x", b))
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            return ""
        }
    }
}
