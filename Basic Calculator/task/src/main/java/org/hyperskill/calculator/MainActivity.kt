package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

enum class Operation(val sign: Char) {
    ADDITION('+'),
    SUBTRACTION('-'),
    DIVISION('/'),
    MULTIPLICATION('*'),
    COMPLETED('=')
}

class MainActivity : AppCompatActivity() {
    var inputField: String = "0"
    var result: Double = 0.0
    var tempValue: Double = 0.0
    var isCalculating: Boolean = false
    lateinit var editText: EditText
    var operation: Operation? = null

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

        val plus: Button = findViewById<Button>(R.id.addButton)
        val minus: Button = findViewById<Button>(R.id.subtractButton)
        val divide: Button = findViewById<Button>(R.id.divideButton)
        val multiply: Button = findViewById<Button>(R.id.multiplyButton)

        val sum: Button = findViewById<Button>(R.id.equalButton)

        button0.setOnClickListener { updateEditText(0) }
        button1.setOnClickListener { updateEditText(1) }
        button2.setOnClickListener { updateEditText(2) }
        button3.setOnClickListener { updateEditText(3) }
        button4.setOnClickListener { updateEditText(4) }
        button5.setOnClickListener { updateEditText(5) }
        button6.setOnClickListener { updateEditText(6) }
        button7.setOnClickListener { updateEditText(7) }
        button8.setOnClickListener { updateEditText(8) }
        button9.setOnClickListener { updateEditText(9) }

        dotButton.setOnClickListener {
            if (inputField.contains(".")) {
                // do nothing
            } else if (inputField.contains("-")) {
                inputField += "0."
                editText.setText(inputField)
            } else {
                inputField += "."
                editText.setText(inputField)
            }
        }

        clearButton.setOnClickListener {
            clearEditText()
            clearResult()
        }

        plus.setOnClickListener {
            if (!isCalculating) {
                result = inputField.toDouble()
                isCalculating = true
            } else {
                result += inputField.toDouble()
            }
            clearEditText()
            operation = Operation.ADDITION
        }

        minus.setOnClickListener {
            if (result == 0.0 && inputField == "0") {
//                result = result * -1
                inputField = "-"
                editText.setText(inputField)
            } else if (inputField == "-") {
                inputField = "0"
                editText.setText(inputField)
            } else {
                if (!isCalculating) {
                    result = inputField.toDouble()
                    isCalculating = true
                } else {
                    result -= inputField.toDouble()
                }
                clearEditText()
                operation = Operation.SUBTRACTION
            }
        }

        divide.setOnClickListener {
            if (!isCalculating) {
                result = inputField.toDouble()
                isCalculating = true
            } else {
                result /= inputField.toDouble()
            }
            clearEditText()
            operation = Operation.DIVISION
        }

        multiply.setOnClickListener {
            if (!isCalculating) {
                result = inputField.toDouble()
                isCalculating = true
            } else {
                result *= inputField.toDouble()
            }
            clearEditText()
            operation = Operation.MULTIPLICATION
        }

        sum.setOnClickListener {
            when (operation) {
                Operation.ADDITION -> result += inputField.toDouble()
                Operation.SUBTRACTION -> result -= inputField.toDouble()
                Operation.DIVISION -> result /= inputField.toDouble()
                Operation.MULTIPLICATION -> result *= inputField.toDouble()
                Operation.COMPLETED -> result = inputField.toDouble()
                else -> {
                    Toast.makeText(this, "SUM: Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
            editText.setText(result.toString())
            inputField = result.toString()
            clearResult()
            clearOperation()
        }

    }

    private fun updateEditText(userInput: Int) {
        if (inputField == "0" && userInput == 0
            || inputField == "-" && userInput == 0
        ) {
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

    fun clearResult() {
        result = 0.0
    }

    private fun clearOperation() {
        isCalculating = false
        operation = Operation.COMPLETED
    }
}
