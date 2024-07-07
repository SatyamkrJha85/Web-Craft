package com.theapplication.webcraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.theapplication.webcraft.Mvvm.Route.NavGraph
import com.theapplication.webcraft.Mvvm.ViewModel.ProductViewModel
import com.theapplication.webcraft.ui.theme.WebCraftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val planerviewmodel = ViewModelProvider(this).get(ProductViewModel::class.java)

        enableEdgeToEdge()
        setContent {
            WebCraftTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Column (
                       modifier = Modifier.padding(innerPadding)
                   ){
                       NavGraph(planerviewmodel)
                   }
                }
            }
        }
    }
}

