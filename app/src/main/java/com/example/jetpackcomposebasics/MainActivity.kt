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
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
                            MyApp()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MyApp() {
    var shouldShowScreen by rememberSaveable { mutableStateOf("Buttons") }
    when(shouldShowScreen){
        "State" -> StateScreen(OnBackButtonClicked = {shouldShowScreen = "Buttons"})
        "LayoutsRow" -> MyRow(OnBackButtonClicked = {shouldShowScreen = "Buttons"})
        "LayoutsColumn" -> MyColumn(OnBackButtonClicked = {shouldShowScreen = "Buttons"})
        "LayoutsBox" -> MyBox(OnBackButtonClicked = {shouldShowScreen = "Buttons"})
//        "Functions" -> FunctionOne("Funktiot!")
        else -> Buttons(OnStateButtonClicked = {shouldShowScreen = "State"},
            OnFunctionsButtonClicked = {shouldShowScreen = "Functions"},
            OnRowButtonClicked = {shouldShowScreen = "LayoutsRow"},
            OnColumnButtonClicked = {shouldShowScreen = "LayoutsColumn"},
            OnBoxButtonClicked = {shouldShowScreen = "LayoutsBox"})
    }
}

@Composable
private fun Buttons(
    OnStateButtonClicked: () -> Unit,
    OnFunctionsButtonClicked: () -> Unit,
    OnRowButtonClicked: () -> Unit,
    OnColumnButtonClicked: () -> Unit,
    OnBoxButtonClicked: () -> Unit, ) {
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
            Button(colors = mainButtonColor,onClick = OnFunctionsButtonClicked, modifier = Modifier.padding(8.dp)) {
                Text(text = "Functions")
            }
        }
        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "This is a text button ")
            }
            TextButton(onClick = OnStateButtonClicked, modifier = Modifier.padding(8.dp)) {
                Text(text = "State")
            }
        }

        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "This is a elevated button ")
            }
            Button(
                onClick = OnRowButtonClicked,
                modifier = Modifier.padding(8.dp),
                elevation = ButtonDefaults.elevation()
            ) {
                Text(text = "Layouts Row")
            }
        }
        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "This is a rounded button ")
            }
            Button(
                onClick =  OnColumnButtonClicked ,
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Layouts Column")
            }
        }
        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "This is a outlined button ")
            }
            OutlinedButton(
                onClick =  OnBoxButtonClicked ,
                border = BorderStroke(2.dp, Color.Yellow),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Layouts Box")
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
            Buttons({}, {}, {}, {}, {})
        }
    }
}