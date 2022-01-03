package org.hyperskill.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var currentStudentName: String? = null

    val lambda = {
        val nameToPrint = currentStudentName ?: "Our Favorite Student"
        println("Welcome $nameToPrint")
    }

    fun main() {
        lambda() // output: Welcome Our Favorite Student
        currentStudentName = "Nate"
        lambda() // output: Welcome Nate
    }
}