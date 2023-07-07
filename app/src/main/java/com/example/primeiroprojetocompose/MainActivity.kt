package com.example.primeiroprojetocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.primeiroprojetocompose.ui.theme.PrimeiroProjetoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeiroProjetoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun Dado(number: Int, modifier: Modifier){
    Canvas(
        modifier = modifier
        .size(96.dp, 96.dp)
    ){
        drawRoundRect(
            Color.Green,
            cornerRadius = CornerRadius(20f , 20f),
            topLeft = Offset(10f , 10f),
            size =  size
        )

        drawCircle(
            Color.Black,
            radius = Dp(20f).value,
            center = Offset(size.width / 2 , size.height / 2)
        )
    }
}

@Composable
fun App(){
    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ){

        Dado(1, Modifier.align(Alignment.Center))
        Dado(2, Modifier.align(Alignment.Center))

        Button(onClick = { },modifier = Modifier
            .align(Alignment.Center)
            .offset(y = (100).dp)
            )  {
            Text("Jogar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimeiroProjetoComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()){
            App()
        }
    }
}