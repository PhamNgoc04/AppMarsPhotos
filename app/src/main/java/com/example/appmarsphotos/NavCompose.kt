package com.example.appmarsphotos

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmarsphotos.nav.Action
import com.example.appmarsphotos.ui.view.ManifestScreen
import com.example.appmarsphotos.ui.view.PhotoScreen
import com.example.appmarsphotos.ui.view.RoverList
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.appmarsphotos.nav.Destinations
import com.example.appmarsphotos.nav.Screen
import com.example.appmarsphotos.ui.view.PhotoListSavedScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavCompose() {

    //items là danh sách các màn hình sẽ được hiển thị trong thành điều hướng
    val items = listOf(
        Screen.Home,
        Screen.Saved
    )

    val navController = rememberNavController() //khởi tạo navController để quản lý việc điều hướng
    val actions = remember(navController) { Action(navController) } //Đã khởi tạo một đối tượng Action để điều hướng

    MaterialTheme {
        Scaffold(bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.drawableId),
                                contentDescription = stringResource(id = screen.resourceId)
                            )
                        },
                        label = {
                            Text(text = stringResource(id = screen.resourceId))
                        },

                        //selected: Kiểm tra xem item này có phải là màn hình hiện tại hay không.
                        selected = currentDestination?.hierarchy?.any {
                            if(it.route?.contains("manifest") == true || it.route?.contains("photo") == true) {
                                screen.route == "home"
                            } else {
                                it.route == screen.route
                            }
                        } == true,

                        //onClick: Khi người dùng nhấn vào item, navController sẽ chuyển tới màn hình tương ứng.
                        onClick = {
                            navController.navigate(screen.route) {

                                //popUpTo: Đảm bảo rằng khi quay lại màn hình trước, trạng thái của màn hình đó sẽ được phục hồi.
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }

            }
        }
        ) { innerPadding ->

            val modifier = Modifier.padding(innerPadding)
            NavHost(navController = navController, startDestination = Destinations.Home) {
                composable(Destinations.Home) {
                    RoverList(
                        modifier = modifier
                    ) { roverName ->
                        actions.manifest(roverName)
                    }
                }
                composable(Destinations.Manifest) { backStackEntry ->
                    ManifestScreen(
                        modifier = modifier,
                        roverName = backStackEntry.arguments?.getString("roverName"),
                        marsRoverManifestViewModel = hiltViewModel(),
                        onClick = { roverName, sol ->
                            actions.photo(roverName, sol)
                        }
                    )
                }
                composable(Destinations.Photo) { backStackEntry ->
                    PhotoScreen(
                        modifier = modifier,
                        roverName = backStackEntry.arguments?.getString("roverName"),
                        sol = backStackEntry.arguments?.getString("sol"),
                        marsRoverPhotoViewModel = hiltViewModel()
                    )
                }
                composable(Destinations.Saved) {
                    PhotoListSavedScreen(
                        modifier = modifier,
                        marsRoverSavedViewModel = hiltViewModel()
                    )
                }
            }
        }
    }
}