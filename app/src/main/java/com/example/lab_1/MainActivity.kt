package com.example.lab_1

import android.content.Context
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        var list: MutableList<Int>
        val textView: TextView = findViewById(R.id.randomListField)
        val inputField: EditText = findViewById(R.id.inputField)
        val resultField: TextView = findViewById(R.id.resultField)
        val newListButton: Button = findViewById(R.id.newListButton)

        list = randomiseList(textView) as MutableList<Int>

        newListButton.setOnClickListener {
            list = randomiseList(textView) as MutableList<Int>
        }

        val runButton: Button = findViewById(R.id.runButton)
        runButton.setOnClickListener {
            updateElements(list, inputField, resultField)
        }
    }
}


fun randomiseList(textView: TextView): List<Int> {
    val list = List(10) { Random.nextInt(0, 99)}
    textView.text = list.joinToString(separator = ", ")
    return list
}

fun updateElements(list: MutableList<Int>, inputField: EditText, resultField: TextView): Unit{
    var list0 = list.toMutableList()
    var count: Int = 0
    var inputData: String = inputField.text.toString()
    count = 0
    if (inputData == "")
        Toast.makeText(inputField.context, "Введите число Z!", Toast.LENGTH_SHORT).show()
    else  {
        for (i in 0..9)
            if (list0[i] > inputData.toInt()) {
                list0[i] = inputData.toInt()
                ++count
            }
        resultField.text = list0.joinToString(separator = ", ")
        Toast.makeText(inputField.context, "Произведено замен: $count ", Toast.LENGTH_SHORT).show()
    }
}
