package com.example.first_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.first_homework.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding;
    private lateinit var model: CardDealerViewModel;
    private lateinit var ImageCard: Array<ImageView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        ImageCard = arrayOf(main.card1, main.card2, main.card3, main.card4, main.card5)

        model = ViewModelProvider(this)[CardDealerViewModel::class.java]
        setImage()

        model.cards.observe(this, Observer {
            Log.i("test","여기 됨")
            setImage()
        })

        main.btnShuffle?.setOnClickListener {

            model.shuffle()
//            model.detectPokerHand()
        }
    }
//    val res = IntArray(5)
//    for (i in it.indices) {
//        res[i] = resources.getIdentifier(
//            getCardName(it[i]),
//            "drawable",
//            packageName
//        )

    private fun setImage() {
        ImageCard.forEachIndexed { index, imageView ->
            Log.i("Test", "${getCardName(model.cards.value!![index])}")
            val imageName = "${getCardName(model.cards.value!![index])}.png"
            val imageResource = resources.getIdentifier(imageName, "drawable", packageName)
            imageView?.setImageResource(imageResource)
        }
    }

    private fun getCardName(c: Int) : String {
        // val에서 var로 변경
        var shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> {
                shape = shape.plus("2")
                "jack"
            }
            11 -> {
                shape = shape.plus("2")
                "queen"
            }
            12 -> {
                shape = shape.plus("2")
                "king"
            }
            else -> "error"
        }

        // 이 방법이 더 나을 듯
//        if (c % 13 in 10..12)
//            return "c_${number}_of_${shape}2"
//        else
//            return "c_${number}_of_${shape}"

        return "c_${number}_of_${shape}"
    }
}
