package com.example.appsemana04_1_geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions(){
        questions= ArrayList()
        var question = Question("Es Lima capital de Peru?", true)
        questions.add(question)

        questions.add(Question("Es Ica capital de Chile?", false))
        questions.add(Question("Es La Paz capital de Bolivia?", true))
        questions.add(Question("Es Santiago capital de Venezuela?", false))
        questions.add(Question("Es Santiago capital de Chile?", true))
        questions.add(Question("Es Bs As capital de Bolivia?", false))
        questions.add(Question("Es Medellin capital de Venezuela?", false))
        questions.add(Question("Es Montevideo capital de Uruguay?", false))
        questions.add(Question("Es Bs As capital de Argentina?", true))

    }

    private fun setupViews(){
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        tvQuestion.text=questions[position].sentence


        btYes.setOnClickListener{
            if(questions[position].answer)
            Toast.makeText(this, "Correct",Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Incorrect",Toast.LENGTH_LONG).show()

        }
        btNo.setOnClickListener{
            if(!questions[position].answer)
            Toast.makeText(this, "Incorrect",Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Correct",Toast.LENGTH_LONG).show()
        }
        btYes.setOnClickListener{
            position++
            tvQuestion.text=questions[position].sentence

        }
    }
}