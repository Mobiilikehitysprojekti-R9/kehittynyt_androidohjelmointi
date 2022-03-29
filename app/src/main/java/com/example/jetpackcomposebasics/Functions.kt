package com.example.jetpackcomposebasics

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

//class Functions : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            JetpackComposeBasicsTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    FunctionOne("Funktiot")
//                }
//            }
//        }
//    }
//}

@Composable
fun FunctionOne(name: String, OnBackButtonClicked: () -> Unit) {
    Button(onClick = OnBackButtonClicked,  modifier = Modifier.padding(8.dp)) {
        Text("Back")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$name!",
            modifier = Modifier.padding(16.dp),
            fontSize = 25.sp,
            color = Color.Blue
        )
        Text(
            text = "Composable funktioihin voidaan koota UI-komponentteja, kuten Text(), Icon() ja OutlinedTextField()",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Text(text = "Tässä lukko:")
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = "lock",
            tint = Color.Blue,
            modifier = Modifier.padding(10.dp)
        )

        val textState = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { Text("OutlinedTextField") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Green,
                unfocusedBorderColor = Black
            )

        )

        Text(
            text = "Composable funktiosta voidaan kutsua myös toisia composable funktioita:",
            modifier = Modifier.padding(20.dp),
            textAlign = TextAlign.Center
        )

        FunctionTwo()
    }

}

@Composable
fun FunctionTwo() {

    val context = LocalContext.current

    Text(
        text = "Toinen funktio napilla!",
        modifier = Modifier.padding(16.dp),
        fontSize = 25.sp,
        color = Color.Red
    )
    Button(
        onClick = {
            Toast.makeText(
                context,
                "Click!",
                Toast.LENGTH_LONG
            ).show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red), modifier = Modifier
            .height(50.dp)
            .width(130.dp)
    ) {
        Text(text = "Nappi", fontSize = 18.sp)
    }
    Text(
        text = "Kutsutaan kolmatta funktiota toisesta funktiosta: ",
        modifier = Modifier.padding(25.dp),
        textAlign = TextAlign.Center
    )
    FunctionThree()

}

@Composable
fun FunctionThree() {

    Text(
        text = "Kolmas funktio!",
        modifier = Modifier.padding(20.dp),
        fontSize = 25.sp,
        color = Color.Cyan
    )
    Row(Modifier.background(Color(0xFFAFEEEE))) {

        Text(text = "Tämä")
        IconFunction()
        Text(text = "on")
        IconFunction()
        Text(text = "rivi")

    }

}

@Composable
fun IconFunction() {
    Icon(
        imageVector = Icons.Default.ArrowForward,
        contentDescription = "arrow",
        tint = Color.Black
    )
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeBasicsTheme {
        FunctionOne("Funktiot", {})
    }
}