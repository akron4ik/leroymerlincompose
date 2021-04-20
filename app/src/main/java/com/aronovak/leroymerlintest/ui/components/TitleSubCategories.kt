package com.aronovak.leroymerlintest.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TitleSubCategories(text: String){
    Text(text = text, style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp))
}