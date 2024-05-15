package com.example.myapplication

import StartScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.ui.theme.NavigationTheme
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val spots = listOf("台北101",
        "國立故宮博物院",
        "中正紀念堂",
        "象山自然步道",
        "太魯閣峽谷",
        "貓空纜車",
        "龍山寺",
        "台北市立動物園",
        "日月潭",
        "九份(九份老街)")

    NavHost(navController = navController, startDestination = Routes.Start) {
        composable(Routes.Start) {
            StartScreen(spots) { index ->
                navController.navigate("${Routes.Detail}/$index")
            }
        }
        composable(
            "${Routes.Detail}/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            val name = spots.getOrNull(index) ?: ""
            DetailScreen(index, name, navController) { navController.navigateUp() }
        }
    }
}

object Routes {
    const val Start = "start"
    const val Detail = "detail"
}

