package com.example.myapplication.shared

import kotlin.coroutines.CoroutineContext

expect val ioDispatcher: CoroutineContext

expect val uiDispatcher: CoroutineContext

