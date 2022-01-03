package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var inputField: String = "0"
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.editText)
        val button0: Button = findViewById<Button>(R.id.button0)
        val button1: Button = findViewById<Button>(R.id.button1)
        val button2: Button = findViewById<Button>(R.id.button2)
        val button3: Button = findViewById<Button>(R.id.button3)
        val button4: Button = findViewById<Button>(R.id.button4)
        val button5: Button = findViewById<Button>(R.id.button5)
        val button6: Button = findViewById<Button>(R.id.button6)
        val button7: Button = findViewById<Button>(R.id.button7)
        val button8: Button = findViewById<Button>(R.id.button8)
        val button9: Button = findViewById<Button>(R.id.button9)
        val dotButton: Button = findViewById<Button>(R.id.dotButton)
        val clearButton: Button = findViewById<Button>(R.id.clearButton)

        button0.setOnClickListener {
            val digit = 0
            updateEditText(digit)
        }

        button1.setOnClickListener {
            val digit = 1
            updateEditText(digit)
        }

        button2.setOnClickListener {
            val digit = 2
            updateEditText(digit)
        }

        button3.setOnClickListener {
            val digit = 3
            updateEditText(digit)
        }

        button4.setOnClickListener {
            val digit = 4
            updateEditText(digit)
        }

        button5.setOnClickListener {
            val digit = 5
            updateEditText(digit)
        }

        button6.setOnClickListener {
            val digit = 6
            updateEditText(digit)
        }

        button7.setOnClickListener {
            val digit = 7
            updateEditText(digit)
        }

        button8.setOnClickListener {
            val digit = 8
            updateEditText(digit)
        }

        button9.setOnClickListener {
            val digit = 9
            updateEditText(digit)
        }

        dotButton.setOnClickListener {
            if (inputField.contains(".")) {
                // do nothing
            } else {
                inputField += "."
                editText.setText(inputField)
            }
        }

        clearButton.setOnClickListener {
            clearEditText()
        }


    }

    private fun updateEditText(userInput: Int) {
        if (inputField == "0" && userInput == 0) {
            // do nothing
        } else if (inputField == "0") {
            inputField = userInput.toString()
            editText.setText(inputField)
        } else {
            inputField += userInput
            editText.setText(inputField)
        }
    }

    fun clearEditText() {
        inputField = "0"
        editText.setText(inputField)
    }
}
