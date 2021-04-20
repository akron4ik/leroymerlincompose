package com.aronovak.leroymerlintest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.CoilImage

data class Product(
    val id: String,
    val url: String,
    val price: Int,
    val description: String
)


@Composable
fun ListOfProducts(title: String, items: List<Product>, onClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(top = 24.dp)) {
        TitleSubCategories(text = title)
        LazyRow(modifier = Modifier.padding(top = 24.dp)) {
            items.map { product ->
                item {
                    ProductCard(item = product, onClick = onClick)
                }

            }
        }

    }
}

@Composable
fun ProductCard(item: Product, onClick: (String) -> Unit) {

    Box(
        modifier = Modifier
            .padding(start = 4.dp, end = 16.dp)
            .height(250.dp)
            .width(150.dp).clickable {onClick(item.description) },
    ) {
        Column() {
            CoilImage(
                data = item.url,
                contentDescription = null,
            )
            Text(
                text = "${item.price} ₽/шт.", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )
            Text(
                text = item.description, style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )
        }
    }


}
