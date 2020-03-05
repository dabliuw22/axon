package com.leysoft.axon.infrastructure.http

import com.leysoft.axon.core.CommandPublisher
import com.leysoft.axon.core.QueryPublisher
import com.leysoft.axon.domain.Person
import com.leysoft.axon.domain.PersonId
import com.leysoft.axon.domain.command.CreatePerson
import com.leysoft.axon.domain.query.GetPersonById
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(val queryPublisher: QueryPublisher, val commandPublisher: CommandPublisher) {

    @GetMapping(value = ["/persons/{personId}"])
    fun getById(@PathVariable("personId") personId: String): ResponseEntity<GetPersonDto> =
            queryPublisher.ask<Person>(personId.toQuery(), Person::class)
                    .let { ResponseEntity.ok(it.toDto()) }

    @PostMapping(value = ["/persons/{personId}"])
    fun create(@PathVariable("personId") personId: String): ResponseEntity<Unit> =
            commandPublisher.publish(CreatePerson(personId, "name"))
                    .let { ResponseEntity.ok(Unit) }

    private fun String.toQuery(): GetPersonById = GetPersonById(this)

    private fun Person.toDto(): GetPersonDto = GetPersonDto.from(this)
}