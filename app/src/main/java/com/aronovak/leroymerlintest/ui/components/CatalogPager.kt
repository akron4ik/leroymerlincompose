package com.aronovak.leroymerlintest.ui.components

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

val itemCatalogList = listOf(
    ItemCatalog(
        url = "https://media.decorateme.com/article2images/d9f4c/paskhalnyi-venok-iz-lozy-s-vetami.jpg",
        query = "Декор"
    ),
    ItemCatalog(
        url = "https://media.decorateme.com/article2images/93e16/paskhalnyi-venok.jpg",
        query = "Стройматериалы"
    ),
    ItemCatalog(
        url = "https://media.decorateme.com/article2images/57215/venok-k-dniu-vliublennykh.jpg",
        query = "Инструменты"
    ),
    ItemCatalog(
        url = "https://media.decorateme.com/article2images/11f62/stekliannye-sosudy-s-dekorativnymi-tykvami.jpg",
        query = "Инструменты"
    ),
    ItemCatalog(
        url = "https://media.decorateme.com/article2images/364e3/tsvetochnyi-dekor-v-podvesnykh-stekliannykh-sosudakh.jpg",
        query = "Инструменты"
    )
)


@Composable
fun CatalogPager() {
    LazyRow {
        itemCatalogList.forEach {
            item { CatalogItem(itemCatalog = it) }
        }
    }
}

@Composable
fun CatalogItem(itemCatalog: ItemCatalog) {
    Box(
        modifier = Modifier
            .padding(top = 24.dp, start = 8.dp, end = 8.dp).height(150.dp).width(150.dp)
            .clip(RoundedCornerShape(8.dp))
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

