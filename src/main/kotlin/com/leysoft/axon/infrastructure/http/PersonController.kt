package com.leysoft.axon.infrastructure.http

import com.leysoft.axon.core.CommandPublisher
import com.leysoft.axon.core.QueryPublisher
import com.leysoft.axon.domain.Person
import com.leysoft.axon.domain.command.CreatePerson
import com.leysoft.axon.domain.query.GetPersonById
import java.net.URI
import java.util.UUID
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(val queryPublisher: QueryPublisher, val commandPublisher: CommandPublisher) {

    @GetMapping(value = ["/persons/{personId}"])
    fun getById(@PathVariable("personId") personId: String): ResponseEntity<GetPersonDto> =
            personId.toQuery().let { queryPublisher.ask<Person>(it, Person::class) }
                .let { ResponseEntity.ok(it.toDto()) }

    @PostMapping(value = ["/persons"])
    fun create(@RequestBody body: CreatePersonDto): ResponseEntity<Unit> {
        val id = UUID.randomUUID().toString()
        return CreatePerson(id = id, name = body.name)
          .let { commandPublisher.publish(it) }
          .let { ResponseEntity.created(URI("/persons/$id")).build() }
    }

    private fun String.toQuery(): GetPersonById = GetPersonById(this)

    private fun Person.toDto(): GetPersonDto = GetPersonDto.from(this)
}
