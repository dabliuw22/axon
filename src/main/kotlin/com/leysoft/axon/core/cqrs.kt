package com.leysoft.axon.core

import java.time.ZonedDateTime
import kotlin.reflect.KClass

interface Command {

    fun id(): String

    fun createdAt(): ZonedDateTime
}
interface Query
interface CommandPublisher {

    fun publish(command: Command)
}
interface QueryPublisher {

    fun <T> ask(query: Query, clazz: KClass<*>): T
}
