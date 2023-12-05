package com.example.middle_test_7intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.middle_test_7intent.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(), OnClickListener {
    companion object {
        const val IMAGE_NAME = "image_name"
        const val IMAGE_RESULT = "image_result"

        const val LIKE = 100
        const val DISLIKE = 101
        const val NONE = 0
    }

    private lateinit var main: ActivityImageBinding
    private lateinit var IDOL: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_image)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)

        IDOL = intent.getStringExtra(MainActivity.KEY_NAME) ?: "none"

        val res = when (IDOL) {
            MainActivity.KARINA -> R.drawable.karina
            MainActivity.WINTER -> R.drawable.winter
            MainActivity.WONYOUNG -> R.drawable.wonyoung
            MainActivity.YUJIN -> R.drawable.yujin
            else -> R.drawable.ic_launcher_foreground
        }
        main.imageView.setImageResource(res)

        main.btnLike.setOnClickListener (this)
        main.btnDislike.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        val value = when (v?.id) {
            main.btnLike.id -> LIKE
            main.btnDislike.id -> DISLIKE
            else -> NONE
        }

        intent.putExtra(IMAGE_NAME, IDOL)
        intent.putExtra(IMAGE_RESULT, value)
        setResult(RESULT_OK, intent)
        finish()
    }
}