package com.leysoft.axon.core

import kotlin.reflect.KClass

interface Command

interface Query

interface CommandPublisher {

    fun publish(command: Command)
}

interface QueryPublisher {

    fun <T> ask(query: Query, clazz: KClass<*>): T
}