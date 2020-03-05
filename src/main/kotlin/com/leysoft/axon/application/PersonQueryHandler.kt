package com.leysoft.axon.application

import com.leysoft.axon.domain.Person
import com.leysoft.axon.domain.query.GetPersonById
import com.leysoft.axon.infrastructure.persistence.repository.PersonRepository
import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Service

@Service
class PersonQueryHandler(val personRepository: PersonRepository) {

    @QueryHandler
    fun handle(query: GetPersonById): Person = personRepository.findById(query.id)
            .let { Person.make(it!!.id, it.name) }
}