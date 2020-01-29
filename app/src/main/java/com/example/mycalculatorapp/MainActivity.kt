package com.example.mycalculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var process: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_clear.setOnClickListener(View.OnClickListener {
            formula.setText("")
            result.setText("")
        })

        btn_backspace.setOnClickListener {
            val s = formula.getText().toString()
            if (s.isNotEmpty()){
                formula.text = s.substring(0,s.length-1)
            }
            result.setText("")
        }

        btn_0.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "0")
        })

        btn_1.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "1")
        })

        btn_2.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "2")
        })

        btn_3.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "3")
        })

        btn_4.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "4")
        })

        btn_5.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "5")
        })

        btn_6.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "6")
        })

        btn_6.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "6")
        })

        btn_7.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "7")
        })

        btn_8.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "8")
        })

        btn_9.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText(process + "9")
        })

        btn_plus.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText("$process+")
        })


        btn_minus.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText("$process-")
        })

        btn_multiply.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText("$process×")
        })

        btn_divide.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText("$process÷")
        })

        btn_decimal.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText("$process.")
        })

        btn_percent.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            formula.setText("$process%")
        })

        btn_equals.setOnClickListener(View.OnClickListener {
            process = formula.getText().toString()
            process = process!!.replace("×".toRegex(), "*")
            process = process!!.replace("%".toRegex(), "/100")
            process = process!!.replace("÷".toRegex(), "/")

            val rhino: Context = Context.enter()
            rhino.setOptimizationLevel(-1)

            var finalResult = ""
            finalResult = try {
                val scriptable: Scriptable = rhino.initStandardObjects()
                rhino.evaluateString(scriptable, process, "AndroidStudio", 1, null).toString()
            } catch (e: Exception) {
                "0"
            }
            result.setText(finalResult)
        })
    }

}
