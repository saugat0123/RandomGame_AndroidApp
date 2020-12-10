package com.saugat.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var layout1: LinearLayout
    lateinit var layout2: LinearLayout
    lateinit var layout3: LinearLayout
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btnstart: Button
    lateinit var btnend: Button
    lateinit var btnrestrt: Button
    lateinit var tvresult: TextView
    lateinit var tvcorrect: TextView
    lateinit var tvincorrect: TextView
    var corr: Int = 0
    var incorr: Int = 0
    var count1: Int = 0
    var count2: Int = 0
    var total: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btnstart = findViewById(R.id.btnstart)
        btnend = findViewById(R.id.btnend)
        btnrestrt = findViewById(R.id.btnrestart)
        tvcorrect = findViewById(R.id.tvcorrect)
        tvincorrect = findViewById(R.id.tvincorrect)
        tvresult = findViewById(R.id.tvresult)
        layout1 = findViewById(R.id.layout1)
        layout2 = findViewById(R.id.layout2)
        layout3 = findViewById(R.id.layout3)

        btnstart.setOnClickListener {
            try {
                layout1.visibility = VISIBLE
                btnrestrt.visibility = VISIBLE
                btnstart.visibility = View.INVISIBLE
                btnend.visibility = VISIBLE
                btnend.isEnabled = false
            }
            catch (ex:Exception)
            {
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
            }
        }

        btn1.setOnClickListener {
            try
            {
                btnend.isEnabled = true
                count1 += 1
                if (btn1.text.toString().toInt() > btn2.text.toString().toInt()) {
                    corr += 1
                }
                else if (btn1.text.toString().toInt() < btn2.text.toString().toInt()) {
                    incorr += 1
                }
                    var rand1: Int = (1 until 30).random()
                    btn2.text = rand1.toString()
                    tvcorrect.text = ("Correct :" + corr)
                    tvincorrect.text = ("Incorrect :" + incorr)
//                if (count1 == 5){
//                    Toast.makeText(this, "Count working", Toast.LENGTH_LONG).show()
//                }
            }
            catch (ex:Exception)
            {
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
            }
        }

        btn2.setOnClickListener {
            try {
                btnend.isEnabled = true
                count2 += 1

                if (btn1.text.toString().toInt() > btn2.text.toString().toInt()) {
                    incorr += 1
                } else if (btn1.text.toString().toInt() < btn2.text.toString().toInt()) {
                    corr += 1
                }

                var rand2: Int = (5 until 35).random()
                btn1.text = rand2.toString()
                tvcorrect.text = ("Correct :" + corr)
                tvincorrect.text = ("Incorrect :" + incorr)
            }
            catch (ex:Exception){
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
            }
        }

        btnend.setOnClickListener {
            try {
                layout2.visibility = VISIBLE
                if (corr > incorr){
                    tvresult.text = ("You Win!! :D")
                }
                else if (corr < incorr){
                    tvresult.text = ("You Lose :(")
                }
                else{
                    tvresult.text = ("Game Draw!! :o")
                }
                layout3.visibility = VISIBLE
            }
            catch (ex:Exception){
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
            }

        }

        btnrestrt.setOnClickListener {
            finish()
            startActivity(intent)
        }

    }
}