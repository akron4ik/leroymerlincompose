package com.aronovak.leroymerlintest.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aronovak.leroymerlintest.data.*
import com.aronovak.leroymerlintest.ui.components.CatalogPager
import com.aronovak.leroymerlintest.ui.components.Header
import com.aronovak.leroymerlintest.ui.components.ListOfProducts
import com.aronovak.leroymerlintest.ui.components.StickyHeader
import com.aronovak.leroymerlintest.viewmodel.MainScreenViewModel


@ExperimentalAnimationApi
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(mainScreenViewModel: MainScreenViewModel = viewModel()) {
    val recentlyProducts by mainScreenViewModel.recentlyOfProducts.observeAsState()
    val limitedOfferProducts by mainScreenViewModel.limitedOfferProducts.observeAsState()
    val bestPriceProducts by mainScreenViewModel.bestPriceProducts.observeAsState()
    val catalogItems by mainScreenViewModel.catalogItems.observeAsState()
    val listState = rememberLazyListState()
    val context = LocalContext.current

    LazyColumn(state = listState) {
        item { Header(mainScreenViewModel = mainScreenViewModel)
        //Имитация логики
        { searchText -> Toast.makeText(context, searchText, Toast.LENGTH_SHORT).show() }
        }
        item { CatalogPager(items = catalogItems.orEmpty())
        { description -> Toast.makeText(context, description, Toast.LENGTH_SHORT).show() }}
        item { ListOfProducts(title = titleRecently, items = recentlyProducts.orEmpty()
        )
        //Имитация логики
        { description -> Toast.makeText(context, description, Toast.LENGTH_SHORT).show() }
        }
        item { ListOfProducts(title = titleLimited, items = limitedOfferProducts.orEmpty())
        //Имитация логики
        { description -> Toast.makeText(context, description, Toast.LENGTH_SHORT).show() }
        }
        item { ListOfProducts(title = titleBestPrice, items = bestPriceProducts.orEmpty())
        //Имитация логики
        { description -> Toast.makeText(context, description, Toast.LENGTH_SHORT).show() }
        }
    }

    val showHeader by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }
    AnimatedVisibility(visible = showHeader) {
         StickyHeader(mainScreenViewModel = mainScreenViewModel)
    }

}