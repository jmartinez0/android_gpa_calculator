package com.example.gpa_juanmartinez_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var grade1 : EditText
    lateinit var grade2 : EditText
    lateinit var grade3 : EditText
    lateinit var grade4 : EditText
    lateinit var grade5 : EditText
    lateinit var computedGpa : TextView
    lateinit var computeGpaButton : Button
    lateinit var background : View
    var gpaCalculated = false;

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
        background = findViewById(R.id.background)
        computeGpaButton.setOnClickListener(View.OnClickListener() {
            computeGpa()
        })
    }

    fun computeGpa() {
        if (!gpaCalculated) {
            if (!fieldsEmpty()) {
                var gpa = getGpa()
                computedGpa.text = gpa.toString()
                setBackgroundColor(gpa)
                computeGpaButton.text = "Clear form"
                gpaCalculated = true;
            } else {
                Toast.makeText(applicationContext, "All fields must be filled", Toast.LENGTH_SHORT).show()
            }
        } else {
            clearFields()
            background.setBackgroundColor(Color.WHITE)
            computeGpaButton.text = "Compute GPA"
            computedGpa.text = "0.0"
            gpaCalculated = false
        }

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

    fun fieldsEmpty() : Boolean {
        return grade1.text.toString().trim().equals("")
                || grade2.text.toString().trim().equals("")
                || grade3.text.toString().trim().equals("")
                || grade4.text.toString().trim().equals("")
                || grade5.text.toString().trim().equals("")
    }

    fun clearFields() {
        grade1.setText("")
        grade2.setText("")
        grade3.setText("")
        grade4.setText("")
        grade5.setText("")
    }

    fun setBackgroundColor(gpa: Double) {
        if (gpa < 60.0) {
            background.setBackgroundColor(Color.RED)
        } else if (gpa > 60.0 && gpa < 80.0) {
            background.setBackgroundColor(Color.YELLOW)
        } else {
            background.setBackgroundColor(Color.GREEN)
        }
    }

}