package com.leysoft.axon.infrastructure.axon

import com.leysoft.axon.core.Event
import com.leysoft.axon.core.EventPublisher
import org.axonframework.eventhandling.gateway.EventGateway
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class DefaultEventPublisher(val eventGateway: EventGateway) : EventPublisher {

    override fun publish(vararg events: Event) = eventGateway.publish(events)

    companion object {
        private val logger = LoggerFactory.getLogger(DefaultEventPublisher.javaClass)
    }
}
