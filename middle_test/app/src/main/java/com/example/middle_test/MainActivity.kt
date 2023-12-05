package com.example.middle_test

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.middle_test.ui.theme.Middle_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Middle_testTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Log.i("context : ", context.toString())
    // 현재의 안드로이드 context를 가져오는 역할, 앱의 환경 정보에 접근하거나 시스템 서비스를 사용할 때

    Column(
        modifier = modifier
    ) {
        Button(
            modifier = modifier.fillMaxWidth(),
            //Button의 modifier에서는 레이아웃의 크기, 행동, 외관등을 변경하거나 사용자 입력을 처리하는 고수준 상호작용을 추가하는데 사용
            onClick = {
                val uri = Uri.parse("https://www.youtube.com/watch?v=fI71L1RamDc")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }) {
            Text("니 옆에 그 사람은 내가 아닌 다른 사람")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            //Button의 modifier에서는 레이아웃의 크기, 행동, 외관등을 변경하거나 사용자 입력을 처리하는 고수준 상호작용을 추가하는데 사용
            onClick = {
                val uri = Uri.parse("https://www.youtube.com/watch?v=t2J4MKGhYF8")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }) {
            Text("빈칸")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            //Button의 modifier에서는 레이아웃의 크기, 행동, 외관등을 변경하거나 사용자 입력을 처리하는 고수준 상호작용을 추가하는데 사용
            onClick = {
                val uri = Uri.parse("https://www.youtube.com/watch?v=DP9aMrVzUf8")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }) {
            Text("그대로일테니")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            //Button의 modifier에서는 레이아웃의 크기, 행동, 외관등을 변경하거나 사용자 입력을 처리하는 고수준 상호작용을 추가하는데 사용
            onClick = {
                val uri = Uri.parse("https://www.youtube.com/watch?v=0GweGYDkxew")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }) {
            Text("어찌잊으라시오")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            //Button의 modifier에서는 레이아웃의 크기, 행동, 외관등을 변경하거나 사용자 입력을 처리하는 고수준 상호작용을 추가하는데 사용
            onClick = {
                val uri = Uri.parse("tel:01064355129")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }) {
            Text("전화")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            //Button의 modifier에서는 레이아웃의 크기, 행동, 외관등을 변경하거나 사용자 입력을 처리하는 고수준 상호작용을 추가하는데 사용
            onClick = {
                val uri = Uri.parse("sms:01075417224")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.putExtra("sms_body", "전화해조")
                startActivity(context, intent, null)
            }) {
            Text("문자")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            //Button의 modifier에서는 레이아웃의 크기, 행동, 외관등을 변경하거나 사용자 입력을 처리하는 고수준 상호작용을 추가하는데 사용
            onClick = {
                val intent = Intent(context, SecondActivity::class.java)
                startActivity(context, intent, null)
            }) {
            Text("Activity")
        }
    }

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Middle_testTheme {
        Greeting("Android")
    }
}