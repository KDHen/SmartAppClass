package com.example.middle_test_7intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.middle_test_7intent.ui.theme.Middle_test_7intentTheme

class AnotherActivity : ComponentActivity() {
    companion object {
        const val IMAGE_NAME = "image name"
        const val IMAGE_RESULT = "image result"

        const val LIKE = 100
        const val DISLIKE = 101
        const val NONE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Middle_test_7intentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IDOLImage()
                }
            }
        }
    }
}



@Composable
fun IDOLImage(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val activity = context as Activity
    val intent = activity.intent
    val imageName = intent.getStringExtra(MainActivity.KEY_NAME)
    val res = when (imageName) {
        MainActivity.KARINA -> R.drawable.karina
        MainActivity.WINTER -> R.drawable.winter
        MainActivity.WONYOUNG -> R.drawable.wonyoung
        MainActivity.YUJIN -> R.drawable.yujin
        else -> R.drawable.ic_launcher_foreground
    }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = res),
        contentDescription = "IDOL Image",
        contentScale = ContentScale.Crop
    )
    Row(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.Bottom),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = {
            onResultClick(activity, imageName, AnotherActivity.LIKE)
        }) {
            Text("Like")
        }
        Button(onClick = {
            onResultClick(activity, imageName, AnotherActivity.DISLIKE)
        }) {
            Text("DISLike")
        }
    }
}

fun onResultClick(activity: Activity, imageName: String?, imageResult: Int) {
    val intent = Intent()
    intent.putExtra(AnotherActivity.IMAGE_NAME, imageName)
    intent.putExtra(AnotherActivity.IMAGE_RESULT, imageResult)
    activity.setResult(ComponentActivity.RESULT_OK, intent)
    activity.finish()
}