package com.android.advicezoid.navigation

sealed class NavigationItem(var route: String, var text: String){
    object Home: NavigationItem("home", "DAILY ADVICE")
    object Favorite: NavigationItem("favorite", "Favorite")

}
