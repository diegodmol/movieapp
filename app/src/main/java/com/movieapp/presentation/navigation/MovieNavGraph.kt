package com.movieapp.presentation.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.runtime.Composable
import com.movieapp.presentation.screen.detail.MovieDetailScreen
import com.movieapp.presentation.screen.home.HomeScreen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object MovieDetail : Screen("movie_detail/{movieId}") {
        fun createRoute(movieId: Int) = "movie_detail/$movieId"
        const val ARG_MOVIE_ID = "movieId"
    }
}

@Composable
fun MovieNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route,
            exitTransition = { fadeOut(animationSpec = androidx.compose.animation.core.tween(200)) },
            popEnterTransition = { fadeIn(animationSpec = androidx.compose.animation.core.tween(200)) }
        ) {
            HomeScreen(
                onMovieClick = { movieId ->
                    navController.navigate(Screen.MovieDetail.createRoute(movieId))
                }
            )
        }

        composable(
            route = Screen.MovieDetail.route,
            arguments = listOf(navArgument(Screen.MovieDetail.ARG_MOVIE_ID) {
                type = NavType.IntType
            }),
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it }) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { it }) + fadeOut()
            }
        ) {
            MovieDetailScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
