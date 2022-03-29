package com.example.jetpackcomposebasics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyRow(OnBackButtonClicked: () -> Unit,) {
    Button(onClick = OnBackButtonClicked,  modifier = Modifier.padding(8.dp)) {
        Text("Back")
    }
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()) {

        Text(
            text = "first",
            fontSize = 22.sp
        )
        Text(
            text = "second",
            fontSize = 22.sp
        )
        Text(
            text = "third",
            fontSize = 22.sp
        )
    }
}
@Preview
@Composable
fun MyRowPreview(){
    MyRow {}
}