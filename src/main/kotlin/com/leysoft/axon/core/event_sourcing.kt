package com.leysoft.axon.core

interface Event
interface EventPublisher {

    fun publish(vararg events: Event)
}
