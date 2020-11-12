package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(view: View) {
        if (view is TextView) {

            var result: String = resultTextView.text.toString()
            var number: String = view.text.toString()

            if (result == "0") {
                result = ""
            }
            if (number.contains(".") && !resultTextView.text.contains(".")){
                number = "0."
            }
            else {
                resultTextView.text = number
            }

            resultTextView.text = result + number
        }

    }

    fun operationClick(view: View) {
        if (view is TextView) {

            if (!TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()

            }

            operation = view.text.toString()

            resultTextView.text = ""
        }

    }
    fun equalsClick(view: View) {

        var secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (!TextUtils.isEmpty(secOperandText)) {
            secOperand = secOperandText.toDouble()
        }
        when (operation) {

            "+" -> resultTextView.text = (operand + secOperand).toString().removeSuffix(".0")
            "-" -> resultTextView.text = (operand - secOperand).toString().removeSuffix(".0")
            "*" -> resultTextView.text = (operand * secOperand).toString().removeSuffix(".0")
            "/" -> resultTextView.text = (operand / secOperand).toString().removeSuffix(".0")
            "%" -> resultTextView.text = (secOperand * (operand / 100)).toString().removeSuffix(".0")
            // 25 % 100 = 25 , 3 % 100 = 3

        }

    }
    fun clearClick(view: View) {

        operand = 0.0
        operation = ""
        resultTextView.text = ""


    }
    fun delClick(view:View) {
        val text = resultTextView.text.toString()

        if (text.isNotEmpty()) {
            resultTextView.text = text.dropLast(1)
        }else if (text.isEmpty()) {
            resultTextView.text = "0"
        }
    }

}