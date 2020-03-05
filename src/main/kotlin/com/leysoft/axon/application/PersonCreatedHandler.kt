package com.leysoft.axon.application

import com.leysoft.axon.domain.event.PersonCreated
import com.leysoft.axon.infrastructure.persistence.entity.PersonEntity
import com.leysoft.axon.infrastructure.persistence.repository.PersonRepository
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Service

@Service
class PersonCreatedHandler(val personRepository: PersonRepository) {

    @EventHandler
    fun handler(event: PersonCreated) {
        personRepository.save(PersonEntity(event.id, event.name))
    }
}