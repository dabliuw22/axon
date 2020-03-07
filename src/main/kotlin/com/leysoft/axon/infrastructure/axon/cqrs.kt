package com.leysoft.axon.infrastructure.axon

import com.leysoft.axon.core.Command
import com.leysoft.axon.core.CommandPublisher
import com.leysoft.axon.core.Query
import com.leysoft.axon.core.QueryPublisher
import kotlin.reflect.KClass
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class DefaultCommandPublisher(val gateway: CommandGateway) : CommandPublisher {

    override fun publish(command: Command) {
        logger.info("Send command: ${command.id()}")
        gateway.sendAndWait<Command>(command)
    }

        companion object {
        private val logger = LoggerFactory.getLogger(DefaultCommandPublisher.javaClass)
    }
}
@Component
class DefaultQueryPublisher(val gateway: QueryGateway) : QueryPublisher {

    override fun <T> ask(query: Query, clazz: KClass<*>): T = (gateway
            .query(query, clazz.javaPrimitiveType ?: clazz.java)
            .get() as T).also { logger.info("Ask query") }

    companion object {
        private val logger = LoggerFactory.getLogger(DefaultQueryPublisher.javaClass)
    }
}
