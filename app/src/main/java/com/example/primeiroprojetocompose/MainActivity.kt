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
import androidx.compose.ui.graphics.drawscope.DrawScope
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

fun DrawScope.circle(offset: (Float) -> Offset) {
    val radius = Dp(20f).value
    drawCircle(
        Color.Black,
        radius = radius,
        center = offset(radius)
    )
}

fun DrawScope.center(){
    circle{
        Offset((size.width /2f) + (it / 2f), (size.height / 2f) + (it / 2f))
    }
}

fun DrawScope.topRight(){
    circle{
        Offset(size.width - it, it * 2f)
    }
}

fun DrawScope.topLeft(){
    circle{
        Offset(it * 2f, it * 2f)
    }
}

fun DrawScope.bottomLeft(){
    circle{
        Offset(it * 2f, size.height - (it))
    }
}

fun DrawScope.bottomRight(){
    circle{
        Offset(size.width - it, size.height - it)
    }
}

fun DrawScope.centerLeft(){
    circle{
        Offset(it*2f, (size.height / 2f) + (it / 2f))
    }
}

fun DrawScope.centerRight(){
    circle{
        Offset(size.width - it, (size.height / 2f) + (it / 2f ))
    }
}

fun DrawScope.bullet(number: Int){
    when(number){
        1 ->{
            center()
        }
        2 -> {
            topRight()
            bottomLeft()

        }
        3 ->{
            center()
            topRight()
            bottomLeft()
        }
        4 -> {
            topRight()
            topLeft()
            bottomRight()
            bottomLeft()
        }
        5 -> {
            center()
            topRight()
            topLeft()
            bottomRight()
            bottomLeft()
        }
        6 -> {
            topRight()
            topLeft()
            centerRight()
            centerLeft()
            bottomRight()
            bottomLeft()
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
            Color.White,
            cornerRadius = CornerRadius(20f, 20f),
            topLeft = Offset(10f, 10f),
            size = size
        )

        bullet(number = number)
    }

}




@Composable
fun App(){
    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ){

       Dado(5,Modifier.align(Alignment.Center))

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