package com.aronovak.leroymerlintest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.transform.CircleCropTransformation
import com.aronovak.leroymerlintest.ui.components.CatalogPager
import com.aronovak.leroymerlintest.ui.components.Header
import com.aronovak.leroymerlintest.viewmodel.MainScreenViewModel
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.glide.GlideImage

@Composable
fun MainScreen(mainScreenViewModel: MainScreenViewModel = viewModel()) {
    Column {
        Header(mainScreenViewModel = mainScreenViewModel)
        CatalogPager()
    }

}