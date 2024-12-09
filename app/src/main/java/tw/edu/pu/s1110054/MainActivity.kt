package tw.edu.pu.s1110054

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tw.edu.pu.s1110054.ui.theme.S1110054Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1110054Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

                    Start(m = Modifier.padding(innerPadding))


                }
            }
        }
    }
}

@Composable
fun Start(m: Modifier){
}