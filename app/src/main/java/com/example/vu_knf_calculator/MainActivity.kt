package com.example.vu_knf_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvOne = findViewById<TextView>(R.id.tvOne)
        val tvTwo = findViewById<TextView>(R.id.tvTwo)
        val tvThree = findViewById<TextView>(R.id.tvThree)
        val tvFour = findViewById<TextView>(R.id.tvFour)
        val tvFive = findViewById<TextView>(R.id.tvFive)
        val tvSix = findViewById<TextView>(R.id.tvSix)
        val tvSeven = findViewById<TextView>(R.id.tvSeven)
        val tvEight = findViewById<TextView>(R.id.tvEight)
        val tvNine = findViewById<TextView>(R.id.tvNine)
        val tvZero = findViewById<TextView>(R.id.tvZero)

        val tvPlus = findViewById<TextView>(R.id.tvPlus)
        val tvEquals = findViewById<TextView>(R.id.tvEquals)
        val tvBack = findViewById<TextView>(R.id.tvBack)
        val tvMinus = findViewById<TextView>(R.id.tvMinus)
        val tvMul = findViewById<TextView>(R.id.tvMul)
        val tvDivide = findViewById<TextView>(R.id.tvDivide)
        val tvDot = findViewById<TextView>(R.id.tvDot)
        val tvClear = findViewById<TextView>(R.id.tvClear)

        val tvExpression = findViewById<TextView>(R.id.tvExpression)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        tvOne.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        tvTwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        tvThree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        tvFour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        tvFive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        tvSix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        tvSeven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        tvEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        tvNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        tvZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

        tvPlus.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                evaluateExpression("+", clear = true)
            }
        }

        tvMinus.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                evaluateExpression("-", clear = true)
            }
        }

        tvMul.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                evaluateExpression("*", clear = true)
            }
        }

        tvDivide.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                evaluateExpression("/", clear = true)
            }
        }

        tvDot.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                evaluateExpression(".", clear = true)
            }

        }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            val text = tvExpression.text.toString()

            if(text.isNotEmpty()) {
                val expression = ExpressionBuilder(text).build()

                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvResult.text = longResult.toString()
                } else {
                    tvResult.text = result.toString()
                }
            }
        }

        tvBack.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                tvExpression.text = text.dropLast(1)
            }

            tvResult.text = ""
        }

        val tvSquare = findViewById<TextView>(R.id.tvSquare)
        tvSquare.setOnClickListener {
            val text = tvExpression.text.toString()

            if(text.isNotEmpty()) {
                val squareRoot = sqrt(text.toDouble())
                tvExpression.text = squareRoot.toString()
            }
            else
                Toast.makeText(this,"Please enter a number", Toast.LENGTH_SHORT).show()
        }

        val tvPercent = findViewById<TextView>(R.id.tvPercent)
        tvPercent.setOnClickListener {
            val text = tvExpression.text.toString()

            if(text.isNotEmpty()) {
                val percent = (text.toDouble() / 100)
                tvExpression.text = percent.toString()
            }
            else
                Toast.makeText(this,"Please enter a number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun evaluateExpression(string: String, clear: Boolean) {

        val tvExpression = findViewById<TextView>(R.id.tvExpression)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        if(clear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }

}
