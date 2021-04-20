package com.aronovak.leroymerlintest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import com.google.accompanist.coil.CoilImage

data class ItemCatalog(
    val url: String = "",
    val query: String = ""
)


@Composable
fun CatalogPager(items: List<ItemCatalog>, onClick: (String) -> Unit) {
    LazyRow {
        items.forEach {
            item { CatalogItem(itemCatalog = it, onClick = onClick) }
        }
    }
}

@Composable
fun CatalogItem(itemCatalog: ItemCatalog, onClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 24.dp, start = 8.dp, end = 8.dp).height(150.dp).width(150.dp)
            .clip(RoundedCornerShape(8.dp)).clickable { onClick(itemCatalog.query) }
    ) {
        CoilImage(
            data = itemCatalog.url,
            contentDescription = null,
            requestBuilder = {
                transformations(RoundedCornersTransformation())
            }
        )

    }
}

