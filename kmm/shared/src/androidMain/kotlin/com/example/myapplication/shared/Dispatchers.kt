package com.example.myapplication.shared

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

actual val ioDispatcher: CoroutineContext
get() = Dispatchers.IO

actual val uiDispatcher: CoroutineContext
get() = Dispatchers.Main

actual fun ktorScope(block: suspend () -> Unit) {
    GlobalScope.launch(uiDispatcher) { block() }
}