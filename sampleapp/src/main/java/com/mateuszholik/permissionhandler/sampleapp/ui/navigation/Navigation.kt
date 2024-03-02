package com.mateuszholik.permissionhandler.sampleapp.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mateuszholik.permissionhandler.sampleapp.ui.camera.CameraPermissionScreen
import com.mateuszholik.permissionhandler.sampleapp.ui.location.LocationPermissionScreen
import com.mateuszholik.permissionhandler.sampleapp.ui.main.MainScreen

object Navigation {

    const val ROOT = "ROOT"
    private const val MAIN_SCREEN = "$ROOT/MAIN_SCREEN"
    private const val CAMERA_PERMISSION_SCREEN = "$ROOT/CAMERA_PERMISSION_SCREEN"
    private const val LOCATION_PERMISSION_SCREEN = "$ROOT/LOCATION_PERMISSION_SCREEN"

    fun NavGraphBuilder.navigationGraph(navController: NavController) {
        navigation(startDestination = MAIN_SCREEN, route = ROOT) {
            mainScreen(navController)
            cameraPermissionScreen(navController)
            locationPermissionScreen(navController)
        }
    }

    private fun NavGraphBuilder.mainScreen(navController: NavController) {
        composable(MAIN_SCREEN) {
            MainScreen(
                onCameraPermissionPressed = { navController.navigateToCameraPermissionScreen() },
                onLocationPermissionPressed = { navController.navigateToLocationPermissionScreen() },
            )
        }
    }

    private fun NavGraphBuilder.cameraPermissionScreen(navController: NavController) {
        composable(CAMERA_PERMISSION_SCREEN) {
            CameraPermissionScreen(
                onBackPressed = { navController.navigateUp() }
            )
        }
    }

    private fun NavGraphBuilder.locationPermissionScreen(navController: NavController) {
        composable(LOCATION_PERMISSION_SCREEN) {
            LocationPermissionScreen(
                onBackPressed = { navController.navigateUp() }
            )
        }
    }

    private fun NavController.navigateToCameraPermissionScreen() =
        navigate(CAMERA_PERMISSION_SCREEN)

    private fun NavController.navigateToLocationPermissionScreen() =
        navigate(LOCATION_PERMISSION_SCREEN)
}
