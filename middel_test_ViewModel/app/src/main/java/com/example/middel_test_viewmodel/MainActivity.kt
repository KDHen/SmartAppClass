package com.example.middel_test_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.middel_test_viewmodel.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    private lateinit var model: LottoViewModel
    private lateinit var txtnum: Array<TextView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifeCycle", "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        txtnum = arrayOf(main.num1, main.num2, main.num3, main.num4, main.num5, main.num6)

        model = ViewModelProvider(this)[LottoViewModel::class.java]
//        setNumbersText()

        model.numbers.observe(this, Observer {
//            setNumbersText()
        })

        main.btnCreate.setOnClickListener {
            model.generate()
        }
    }

//    fun setNumbersText()
//    {
//        txtnum.forEachIndexed{ index, textView ->
//            textView?.text = model.numbers.value!![index].toString() // null값이 아닌 값을 보장한다.
//        }
//    }

    private fun getCardName(c: Int) : String {
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
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