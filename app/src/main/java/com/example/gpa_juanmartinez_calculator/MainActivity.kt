package com.example.gpa_juanmartinez_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var grade1 : EditText
    lateinit var grade2 : EditText
    lateinit var grade3 : EditText
    lateinit var grade4 : EditText
    lateinit var grade5 : EditText
    lateinit var computedGpa : TextView
    lateinit var computeGpaButton : Button
    var gpaCalculated = false;
    var fieldsClear = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        grade1 = findViewById(R.id.grade_one)
        grade2 = findViewById(R.id.grade_two)
        grade3 = findViewById(R.id.grade_three)
        grade4 = findViewById(R.id.grade_four)
        grade5 = findViewById(R.id.grade_five)
        computedGpa = findViewById(R.id.gpa)
        computeGpaButton = findViewById(R.id.button)
        computeGpaButton.setOnClickListener(View.OnClickListener() {
            computeGpa()
        })
    }

    fun computeGpa() {
        /*
        if (!gpaCalculated) {
            if (!fieldsClear) {

            }
        }*/
        var tt = getGpa()
        computedGpa.text = tt.toString()
    }

    fun getGpa() : Double {
        var result = 0.0
        result += Integer.parseInt(grade1.text.toString().trim())
        result += Integer.parseInt(grade2.text.toString().trim())
        result += Integer.parseInt(grade3.text.toString().trim())
        result += Integer.parseInt(grade4.text.toString().trim())
        result += Integer.parseInt(grade5.text.toString().trim())
        result /= 5.0
        return result
    }


}