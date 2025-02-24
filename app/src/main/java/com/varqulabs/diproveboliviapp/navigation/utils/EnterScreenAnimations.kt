package com.varqulabs.diproveboliviapp.navigation.utils

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.navigation.NavBackStackEntry

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInToRight() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(600)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutToRight() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(600)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutToLeft() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(600)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInToLeft() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(600)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.enterZoomIn() =
    scaleIn(
        initialScale = 0.8f, // Comenzamos con un tamaño más pequeño
        animationSpec = tween(500)
    ) + fadeIn(
        animationSpec = tween(500)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.exitZoomOut() =
    scaleOut(
        targetScale = 1.2f, // Se agranda un poco antes de desaparecer
        animationSpec = tween(500)
    ) + fadeOut(
        animationSpec = tween(500)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.popEnterZoomIn() =
    scaleIn(
        initialScale = 1.2f, // Aparece un poco más grande y se ajusta
        animationSpec = tween(500)
    ) + fadeIn(
        animationSpec = tween(500)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.popExitZoomOut() =
    scaleOut(
        targetScale = 0.8f, // Se reduce antes de salir
        animationSpec = tween(500)
    ) + fadeOut(
        animationSpec = tween(500)
    )
