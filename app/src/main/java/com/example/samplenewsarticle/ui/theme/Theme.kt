package com.example.samplenewsarticle.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = Color.Blue,
    primaryVariant = Color.DarkGray,
    secondary = Color.Red
)

private val DarkColorPalette = darkColors(
    primary = Color.Green,
    primaryVariant = Color.DarkGray,
    secondary = Color.Yellow
)

@Composable
fun NewsArticlesTheme(darkTheme: Boolean = false, content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        content = content
    )
}