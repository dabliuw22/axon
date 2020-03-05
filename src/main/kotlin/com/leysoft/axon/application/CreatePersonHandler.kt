package com.leysoft.axon.application

import com.leysoft.axon.core.EventPublisher
import com.leysoft.axon.domain.command.CreatePerson
import com.leysoft.axon.domain.event.PersonCreated
import org.axonframework.commandhandling.CommandHandler
import org.springframework.stereotype.Service

@Service
class CreatePersonHandler(val publisher: EventPublisher) {

    // @CommandHandler
    fun handler(command: CreatePerson) {
        print("CommandHandler")
        publisher.publish(PersonCreated(command.id, command.name))
    }
}