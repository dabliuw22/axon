package com.leysoft.axon.infrastructure.http

import com.leysoft.axon.domain.Person

data class GetPersonDto(val id: String, val name: String) {

    companion object {
        fun from(person: Person): GetPersonDto =
                GetPersonDto(person.id.value, person.name.value)
    }
}

data class CreatePersonDto(val name: String)
