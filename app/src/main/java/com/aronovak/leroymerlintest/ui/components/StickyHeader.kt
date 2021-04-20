package com.aronovak.leroymerlintest.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.aronovak.leroymerlintest.viewmodel.MainScreenViewModel

@Composable
fun StickyHeader(mainScreenViewModel: MainScreenViewModel){

    val searchText by mainScreenViewModel.searchText.observeAsState()
    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = searchText.orEmpty(),
            onValueChange = {text -> mainScreenViewModel.setSearchText(text)},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Поиск") },
            colors = TextFieldDefaults
                .textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black)
        )
    }

}