package com.example.restapi2.uicontroller

fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                navigateToItemUpdate = { id ->
                    navController.navigate("item_edit/$id")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Route untuk Edit
        composable(
            route = "item_edit/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
        // Di dalam NavHost
        composable(
            route = DestinasiEdit.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEdit.siswaIdArg) { type = NavType.IntType })
        ) {
            EditSiswaScreen(navigateBack = { navController.popBackStack() })
        }

        composable(
            route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.siswaIdArg) { type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt(DestinasiDetail.siswaIdArg) ?: 0
            DetailSiswaScreen(
                navigateBack = { navController.popBackStack() },
                navigateToEdit = { navController.navigate("${DestinasiEdit.route}/$id") }
            )
        }
    }
}