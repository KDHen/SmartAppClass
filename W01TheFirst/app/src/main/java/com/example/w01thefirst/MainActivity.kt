package com.example.w01thefirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.w01thefirst.databinding.ActivityMainBinding
import kotlin.random.Random
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    private lateinit var model: LottoViewModel
    private lateinit var txtNum: Array<TextView?> // 얘가 하는 역할이 뭐지?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Log.i("Lifecycle!!!", "onCreate")

        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        txtNum = arrayOf(main.btn1, main.btn2, main.btn3, main.btn4, main.btn5, main.btn6)

        model = ViewModelProvider(this)[LottoViewModel::class.java]
        setNumbersText()

        main.btn7.setOnClickListener {
            model.generate()
            setNumbersText()
//            main.btn1.text = Random.nextInt(1, 46).toString()
//            main.btn2.text = Random.nextInt(1, 46).toString()
//            main.btn3.text = Random.nextInt(1, 46).toString()
//            main.btn4.text = Random.nextInt(1, 46).toString()
//            main.btn5.text = Random.nextInt(1, 46).toString()
//            main.btn6.text = Random.nextInt(1, 46).toString()
        }
    }
    private fun setNumbersText() {
        txtNum.forEachIndexed { index, textView ->
            textView?.text = model.numbers.value!![index].toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle!!!", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle!!!", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle!!!", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle!!!", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle!!!", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle!!!", "onDestroy")
    }
}