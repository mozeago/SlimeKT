/*
 * Copyright (C) 2021, Kasem S.M
 * All rights reserved.
 */
package kasem.sm.slime.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kasem.sm.common_ui.util.Routes

@Composable
fun NavController.currentRouteAsState(): String? {
    return currentBackStackEntryAsState().value?.destination?.route
}

@Composable
fun NavController.isNotAuthRoute(): Boolean {
    return when (currentRouteAsState()) {
        Routes.HomeScreen.route -> true
        Routes.ExploreScreen().route -> true
        Routes.ProfileScreen.route -> true
        Routes.BookmarkScreen.route -> true
        else -> false
    }
}

@Composable
fun NavController.isProfileScreenRoute(): Boolean {
    return currentRouteAsState() == Routes.ProfileScreen.route
}
