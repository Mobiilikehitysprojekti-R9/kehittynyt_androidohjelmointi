package com.example.jetpackcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                JetpackComposeBasicsTheme {
                    Surface(color = Color.LightGray) {
                        Column {
                            Buttons()
                        }
                    }
                }
            }
        }
    }
}



@Composable
private fun Buttons() {
    /*val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Buttons") {
        composable(route="Buttons") { Buttons(navController) }
        composable(route="Layouts") { Layouts() }

    }*/
Column (){
    Text(text = "Jetpack Compose Basics", style = typography.h3, textAlign = TextAlign.Center)
    Text(text = "Buttons", style = typography.h5, fontStyle = FontStyle.Italic, modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold)
}

    Column {
        val mainButtonColor = ButtonDefaults.buttonColors(
            backgroundColor = Color.Cyan,
            contentColor = MaterialTheme.colors.surface
        )
        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(0.1f)) {
                Text(text = "This is a basic button ")
                Text(text = "with changed background color ")
            }
            Button(colors = mainButtonColor,onClick = {}, modifier = Modifier.padding(8.dp)) {
                Text(text = "Layouts")
            }
        }
        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "This is a text button ")
            }
            TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
                Text(text = "Functions")
            }
        }

        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "This is a elevated button ")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
                elevation = ButtonDefaults.elevation()
            ) {
                Text(text = "State")
            }
        }
        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "This is a rounded button ")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Rounded")
            }
        }
        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "This is a outlined button ")
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                border = BorderStroke(2.dp, Color.Yellow),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Outlined")
            }
        }
        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "This is a icon button ")
            }
            Button(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Row {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Icon Button")
                }
            }
        }
    }
}
@Preview
@Composable
fun Layouts() {
    Row(modifier = Modifier.padding(20.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "This is a text button ")
        }
        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Functions")
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    JetpackComposeBasicsTheme {
        Column {
            Buttons()
        }
    }
}