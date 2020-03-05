package com.leysoft.axon.domain

interface GetPersonRepository {

    fun getBy(id: PersonId): Person
}