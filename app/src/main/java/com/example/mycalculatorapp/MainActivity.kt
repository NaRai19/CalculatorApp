package com.example.mycalculatorapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bar_layout.*
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable


class MainActivity : AppCompatActivity() {

    var process: String? = null
//    var history: List<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_clear.setOnClickListener(View.OnClickListener {
            tv_input.setText("")
            result.setText("")
        })

        btn_backspace.setOnClickListener {
            val s = tv_input.getText().toString()
            if (s.isNotEmpty()){
                tv_input.text = s.substring(0,s.length-1)
            }
            result.setText("")
        }

        btn_0.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "0")
        })

        btn_1.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "1")
        })

        btn_2.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "2")
        })

        btn_3.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "3")
        })

        btn_4.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "4")
        })

        btn_5.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "5")
        })

        btn_6.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "6")
        })

        btn_6.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "6")
        })

        btn_7.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "7")
        })

        btn_8.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "8")
        })

        btn_9.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText(process + "9")
        })

        btn_plus.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText("$process+")
        })


        btn_minus.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText("$process-")
        })

        btn_multiply.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText("$process×")
        })

        btn_divide.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText("$process÷")
        })

        btn_decimal.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText("$process.")
        })

        btn_percent.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
            tv_input.setText("$process%")
        })

        btn_equals.setOnClickListener(View.OnClickListener {
            process = tv_input.getText().toString()
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
//            history.add(String.valueOf(result)
        })

        btn_History.setOnClickListener {
                var intent : Intent = Intent(this@MainActivity,HistoryActivity::class.java)
                startActivity(intent)
        }
    }

}
