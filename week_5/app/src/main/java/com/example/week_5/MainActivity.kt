package com.example.week_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week_5.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    private lateinit var model: CardDealerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        main= ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        model = ViewModelProvider(this)[CardDealerViewModel::class.java]
        model.cards.observe(this, Observer {
            val res = IntArray(5)
            for (i in res.indices) {
                res[i] = resources.getIdentifier(
                    getCardName(it[i]),
                    "drawable",
                    packageName
                )
            }
            main.card1.setImageResource(res[0])
        })

        main.btn1.setOnClickListener {
            model.shuffle() // 왜 셔플만 불러도 되는지 알기 위에서 옵저버에서 실행하고 있기때문에 그런듯
        }

//        main.imgCard1.setImageResource(R.drawable.c_2_of_spades)

        val c = Random.nextInt(52)
        Log.i("Test", "$c : ${getCardName(c)}")

        val res = resources.getIdentifier(
            getCardName(c),
            "drawable",
            packageName
        )

        main.card1.setImageResource(res)
    }

    private fun getCardName(c: Int) : String {
        var shape = when (c/13) {
            0 -> "spades"
            1 -> "hearts"
            2 -> "diamonds"
            3 -> "clubs"
            else -> "error"
        }
        var number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
    }
}