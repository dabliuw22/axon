package com.leysoft.axon.domain

import com.leysoft.axon.domain.command.CreatePerson
import com.leysoft.axon.domain.event.PersonCreated
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle.apply
import org.axonframework.spring.stereotype.Aggregate

data class PersonId(val value: String)
data class PersonName(val value: String)
@Aggregate
class Person {

    @AggregateIdentifier
    lateinit var id: PersonId

    lateinit var name: PersonName

    constructor()

    @CommandHandler
    constructor(command: CreatePerson) {
        apply(PersonCreated(command.id, command.name))
    }

    @EventSourcingHandler
    fun on(event: PersonCreated) {
        println("EventSourcingHandler")
        this.id = PersonId(event.id)
        this.name = PersonName(event.name)
    }

    companion object {

        fun make(id: String, name: String): Person {
            val person = Person()
            person.id = PersonId(id)
            person.name = PersonName(name)
            return person
        }
    }
}
