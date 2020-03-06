package com.leysoft.axon.core

import java.time.ZonedDateTime

interface Event {

    fun id(): String

    fun createdAt(): ZonedDateTime
}
interface EventPublisher {

    fun publish(vararg events: Event)
}
