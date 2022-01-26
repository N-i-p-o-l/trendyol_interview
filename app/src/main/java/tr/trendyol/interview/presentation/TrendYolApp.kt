package tr.trendyol.interview.presentation

import android.content.Context
import android.net.ConnectivityManager
import androidx.compose.material.AlertDialog
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import tr.trendyol.interview.R
import tr.trendyol.interview.domain.entity.BannerContent
import tr.trendyol.interview.presentation.detail.DetailScreen
import tr.trendyol.interview.presentation.home.HomeScreen
import tr.trendyol.interview.presentation.home.HomeViewModel
import tr.trendyol.interview.presentation.splash.SplashScreen

@Composable
fun TrendYolApp() {
    val context = LocalContext.current
    var isOnline by remember { mutableStateOf(checkIfOnline(context)) }
    if (isOnline) {
        TrendYolAppMain()
    }
    else {
        OfflineDialog { isOnline = checkIfOnline(context) }
    }
}

@Composable
fun TrendYolAppMain() {
    val navController = rememberNavController()
    Scaffold() {
        NavHost(navController, startDestination = Screens.SplashScreen.route) {
            composable(Screens.SplashScreen.route) {
                SplashScreen {
                    navController.navigate(Screens.HomeScreen.route)
                }
            }
            composable(Screens.HomeScreen.route) {
                val homeViewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(homeViewModel, navToDetail = {
                    navController.navigate(
                        Screens.DetailScreen.route
                            .plus("/?title=${it.title}?order=${it.displayOrder}?imgUrl=${it.imageUrl}")
                    )
                })
            }
            composable(
                route = Screens.DetailScreen.route
                    .plus("/?title={title}?order={order}?imgUrl={imgUrl}"),
                arguments = listOf(
                    navArgument("title") {
                        type = NavType.StringType
                    },
                    navArgument("order") {
                        type = NavType.IntType
                    },
                    navArgument("imgUrl") {
                        type = NavType.StringType
                    }
                )
            ) {
                val title = navController.currentBackStackEntry?.arguments?.getString("title")
                val order = navController.currentBackStackEntry?.arguments?.getInt("order")
                val imgUrl = navController.currentBackStackEntry?.arguments?.getString("imgUrl")

                DetailScreen(banner = BannerContent(title ?: "", order ?: 1, imgUrl ?: ""),
                    onBackPressed = { navController.navigateUp() })
            }
        }
    }
}

sealed class Screens (val route: String) {
    object SplashScreen: Screens("splash")
    object HomeScreen: Screens("home")
    object DetailScreen: Screens("detail")
}

@Suppress("DEPRECATION")
private fun checkIfOnline(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
}

@Composable
fun OfflineDialog(onRetry: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(stringResource(R.string.connection_error)) },
        text = { Text(stringResource(R.string.check_connection)) },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text(stringResource(R.string.retry_label))
            }
        }
    )
}