package com.nimetatila.ticketapp.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nimetatila.ticketapp.screen.LoginScreen
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.nimetatila.ticketapp.screen.RegisterScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    //authRepository: AuthRepository = koinInject()
)
{
    NavHost(navController=navController, startDestination = Login) {
        composable<Login>{
            LoginScreen(
                onLoginSuccess = {navController.navigate(Home)},
                onNavigateToRegister = {navController.navigate(Register)}
            )
        }
        composable<Register> {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(Login){
                        popUpTo(Register){inclusive = true}
                    }
                },
                onNavigateToLogin = {
                    navController.navigate(Login) {
                        popUpTo(Register) { inclusive = true }
                    }
                }

            )
        }
        composable<Home> {
            Text("Home Screen")
        }
    }
}
//uygulamanın ekran akışını tanımladığımız yer
//navController: NavHostController = rememberNavController() => ekranlar arası geçişi yönetir