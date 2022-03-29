package com.example.jetpackcomposebasics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyBox(
    OnBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Button(onClick = OnBackButtonClicked,
            modifier = modifier.padding(8.dp).align(TopEnd)) {
            Text("Back")
        }
        Text(
            text = stringResource(id = R.string.first),
            fontSize = 22.sp,
            modifier = contentModifier.align(Alignment.TopStart)
        )

        Text(
            text = stringResource(id = R.string.second),
            fontSize = 22.sp,
            modifier = contentModifier.align(Alignment.Center)
        )
        Text(
            text = stringResource(id = R.string.third),
            fontSize = 22.sp,
            modifier = contentModifier.align(Alignment.BottomEnd)
        )
    }
}
@Preview
@Composable
fun MyBoxPreview(){
    MyBox({})
}
