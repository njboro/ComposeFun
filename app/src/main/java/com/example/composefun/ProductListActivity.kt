package com.example.composefun

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composefun.data.model.Product
import com.example.composefun.ui.theme.ComposeFunTheme
import com.example.composefun.viewmodel.ProductViewModel


class ProductListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFunTheme {
                ProductsListScreen()
            }
        }
    }


    @Composable
    fun ProductsListScreen(viewModel: ProductViewModel = viewModel()) {
        val products by viewModel.products.collectAsState()
        LazyColumn {
            items(products) { product ->
                ProductItem(product)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.DarkGray
                )
            }
        }
    }

    @Composable
    fun ProductItem(product: Product) {
        val context = LocalContext.current
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Product image",
                    modifier = Modifier
                        .border(
                            color = Color.Black,
                            shape = RectangleShape,
                            width = 2.dp
                        ).height(200.dp).weight(2f),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Product image",
                        modifier = Modifier
                            .border(
                                color = Color.Black,
                                shape = RectangleShape,
                                width = 2.dp
                            ).height(100.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Product image",
                        modifier = Modifier
                            .border(
                                color = Color.Black,
                                shape = RectangleShape,
                                width = 2.dp
                            ).height(100.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(
                    start = 16.dp, end = 16.dp
                )
            ) {
                Text(
                    text = product.name,
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                )

                Button(onClick = {
                    Toast.makeText(context, "Added to cart successfully", Toast.LENGTH_LONG).show()
                }) {
                    Text("Add to cart")
                }
            }
        }
    }
}