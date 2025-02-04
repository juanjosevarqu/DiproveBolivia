package com.varqulabs.diproveboliviapp.core.presentation.utils.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/*
 * MVI Template for Jetpack Compose state management.
 * Based on the works of:
 * - Rusvel Leyva: https://github.com/repleyva (Medium: https://medium.com/@repleyva/android-arquitectura-mvi-usando-jetpack-compose-c244f34e0221)
 * - Ilyas Ipek: https://github.com/ilyasipek (Medium: https://engineering.teknasyon.com/how-to-implement-mvi-with-delegates-on-android-f2aa1a842b73)
 */

interface MVIContract<State, Event, UiEffect> {
    val uiState: StateFlow<State>
    val uiEffect: Flow<UiEffect>

    fun eventHandler(event: Event)

    fun setState(newState: State)

    fun updateUi(update: State.() -> State)

    fun CoroutineScope.emitEffect(effect: UiEffect)
}

/**
 * A helper function to destructure the [MVIContract] into its individual parts.
 *
 * Example usage:
 * ```
 * val (state, eventHandler, uiEffect) = mvi.toTriple()
 * ```
 * */
@Stable
@Composable
fun <State, Event, UiEffect> MVIContract<State, Event, UiEffect>.toTriple() =
    Triple(uiState.collectAsState().value, ::eventHandler, uiEffect)