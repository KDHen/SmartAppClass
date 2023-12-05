package com.example.middle_test_7intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.middle_test_7intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    companion object {
        const val KEY_NAME = "IDOL"
        const val KARINA = "karina"
        const val WINTER = "winter"
        const val YUJIN = "yujin"
        const val WONYOUNG = "wonyoung"
    }

    private lateinit var main: ActivityMainBinding

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
        if(it.resultCode != Activity.RESULT_OK)
            return@registerForActivityResult

        val result = it.data?.getIntExtra(
            ImageActivity.IMAGE_RESULT,
            ImageActivity.NONE
        )
        val str = when (result) {
            ImageActivity.LIKE -> "LIKE"
            ImageActivity.DISLIKE -> "DISLIKE"
            else -> ""
        }

        when (it.data?.getStringExtra(ImageActivity.IMAGE_NAME)) {
            KARINA -> main.karina.text = "karina ($str)"
            WINTER -> main.winter.text = "winter ($str)"
            YUJIN -> main.yuJin.text = "yujin ($str)"
            WONYOUNG -> main.wonYoung.text = "wonyoung ($str)"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.karina.setOnClickListener (this)
        main.winter.setOnClickListener (this)
        main.yuJin.setOnClickListener (this)
        main.wonYoung.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, ImageActivity::class.java)

        val value = when (v?.id) {
            main.karina.id -> {
                Toast.makeText(this, KARINA, Toast.LENGTH_SHORT).show()
                KARINA
            }
            main.winter.id -> {
                Toast.makeText(this, WINTER, Toast.LENGTH_SHORT).show()
                WINTER
            }
            main.yuJin.id -> {
                Toast.makeText(this, YUJIN, Toast.LENGTH_SHORT).show()
                YUJIN
            }
            main.wonYoung.id -> {
                Toast.makeText(this, WONYOUNG, Toast.LENGTH_SHORT).show()
                WONYOUNG
            }
            else -> return
        }
        intent.putExtra(KEY_NAME, value)
//        startActivity(intent)
        startForResult.launch(intent)
    }
}