package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    TaskManagerApp(

                    )
                }
            }
        }
    }
}
@Composable
fun TaskManagerApp(){
    TaskManagerCard(
        image = painterResource(id = R.drawable.ic_task_completed),
        statusText = stringResource(id = R.string.status_text) ,
        lastText = stringResource(id = R.string.last_text))
}

@Composable
fun TaskManagerCard(
    image: Painter,
    statusText: String,
    lastText: String,
    modifier: Modifier = Modifier
){
    Column(modifier= Modifier.fillMaxWidth().fillMaxHeight(), verticalArrangement = Arrangement
        .Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = image,contentDescription = null)
        Text(
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            text = statusText,
            modifier = modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp)
        )
        Text(
            fontSize = 16.sp,
            text = lastText,
        )

    }
}

@Preview(showBackground = true, showSystemUi = true )
@Composable
fun GreetingPreview() {
    TaskManagerApp()
}