package com.aronovak.leroymerlintest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.QrCode2
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aronovak.leroymerlintest.ui.theme.MainGreen
import com.aronovak.leroymerlintest.viewmodel.MainScreenViewModel

@Composable
fun Header(mainScreenViewModel: MainScreenViewModel, onClick: (String) -> Unit) {
    val headerText = "Поиск товаров"
    Column(
        modifier = Modifier
            .background(MainGreen)
            .padding(bottom = 12.dp)
    ) {
        HeaderText(headerText)
        SearchRow(mainScreenViewModel = mainScreenViewModel, onClick = onClick)

    }

}

@Composable
fun HeaderText(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(
            start = 16.dp, top = 24.dp
        ),
        style = TextStyle(
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun SearchRow(mainScreenViewModel: MainScreenViewModel, onClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 16.dp, top = 24.dp).fillMaxWidth()
    ) {
        Box(Modifier.weight(0.7f)) {
            Search(mainScreenViewModel = mainScreenViewModel, onClick = onClick)
        }
        Box(
            modifier = Modifier
                .weight(0.3f)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            QRBtn(shape = RoundedCornerShape(10.dp))
        }

    }

}

@Composable
fun Search(mainScreenViewModel: MainScreenViewModel, onClick: (String) -> Unit) {
    val searchText by mainScreenViewModel.searchText.observeAsState()

    TextField(
        value = searchText.orEmpty(),
        onValueChange = { text -> mainScreenViewModel.setSearchText(text) },
        modifier = Modifier.width(550.dp),
        placeholder = { Text(text = "Поиск") },
        trailingIcon = {
            SearchBtn(
                shape = RoundedCornerShape(10.dp),
                mainScreenViewModel = mainScreenViewModel,
                onClick = onClick)
        },
        colors = TextFieldDefaults
            .textFieldColors(
                backgroundColor = Color.White,
                textColor = Color.Black)
    )

}

@Composable
fun SearchBtn(shape: RoundedCornerShape, mainScreenViewModel: MainScreenViewModel, onClick: (String) -> Unit) {
    val searchText by mainScreenViewModel.searchText.observeAsState()
    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .clip(shape = shape)
            .clickable { onClick(searchText.orEmpty()) }
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .background(MainGreen),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Rounded.Search, contentDescription = "", tint = Color.White)
        }

    }
}

@Composable
fun QRBtn(shape: RoundedCornerShape) {
    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .clip(shape = shape)
            .clickable { }
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Rounded.QrCode2, contentDescription = "", tint = Color.Black)
        }
    }


}
