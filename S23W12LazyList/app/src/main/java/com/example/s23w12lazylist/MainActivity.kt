package com.example.s23w12lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s23w12lazylist.ui.theme.S23W12LazyListTheme

data class Song(var title: String, var singer: String)
private val songs = mutableListOf<Song>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repeat(10) {
            songs.add(Song("테스형", "나훈아"))
            songs.add(Song("excause me", "AOA"))
            songs.add(Song("빈칸", "모름"))
        }
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    S23W12LazyListTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyList()
        }
    }
}

@Composable
fun MyList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(songs) {
            SongItem(it)
        }
    }
}

@Composable
fun SongItem(song: Song){
    Column (
        modifier = Modifier.fillMaxWidth().background(Color(0xffffffcc)).padding(16.dp)
    ){
        TextTitle("노래 ${song.title}")
        TextSinger("가수는 가수 ${song.singer} 입니다.")
    }
}

@Composable
fun TextSinger(singer : String) {
    Text(singer, fontSize = 20.sp)
}

@Composable
fun TextTitle(title: String) {
    Text(title, fontSize = 30.sp)
}