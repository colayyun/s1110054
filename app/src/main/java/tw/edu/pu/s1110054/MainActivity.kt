package tw.edu.pu.s1110054

import android.content.pm.ActivityInfo
import android.media.Image
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import tw.edu.pu.s1110054.ui.theme.S1110054Theme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button

import androidx.compose.ui.platform.LocalContext
import android.app.Activity
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

import androidx.compose.foundation.layout.size



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1110054Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

                    Greeting(
                        name ="2024期末上機考(資管三B洪可芸)",
                        modifier = Modifier.padding(innerPadding)
                    )

                    val scale = resources.displayMetrics.density
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


    val colors = listOf(
        Color(0xff95fe95),
        Color(0xfffdca0f),
        Color(0xfffea4a4),
        Color(0xffa5dfed)
    )
    var currentIndex by remember { mutableStateOf(0) }
    var gameTime by remember { mutableStateOf(0) }
    var mariaPosition by remember { mutableStateOf(0f) }
    var gameEnded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (!gameEnded) {
            delay(1000L)
            gameTime += 1
            mariaPosition += 50f

            if (mariaPosition > 1080f) {
                gameEnded = true
            }
        }
    }






    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors[currentIndex])
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    change.consume()
                    if (dragAmount > 100) {

                        currentIndex = (currentIndex - 1 + colors.size) % colors.size
                    } else {
                        currentIndex = (currentIndex + 1) % colors.size
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {


            Text(
                text = "$name!",
                modifier = modifier
            )

            Image(
                painter = painterResource(id = R.drawable.class_b),
                contentDescription = "B班",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
            )

            Text(
                text = "遊戲持續時間 $gameTime 秒",
                modifier = modifier
            )


            Text(
                text = "您的成績 0 分",
                modifier = modifier
            )

            if (gameEnded) {
                Text(
                    text = "遊戲結束！",
                    fontSize = 16.sp,
                    color = Color.Red
                )
            }

            val activity = (LocalContext.current as? Activity)

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Button(
                    onClick = {

                        activity?.finish()
                    }
                ) {
                    Text("結束App")
                }
            }

            val virusImage = arrayListOf(R.drawable.maria2)
            Image(
                painter = painterResource(id = virusImage[0]),
                contentDescription = "病毒",
                modifier = Modifier
                    .size(80.dp)
                    .offset { IntOffset(1000, y = 200) }
            )


        }
    }
}







            

