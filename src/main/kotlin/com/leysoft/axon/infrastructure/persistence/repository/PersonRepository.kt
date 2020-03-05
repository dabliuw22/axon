package com.leysoft.axon.infrastructure.persistence.repository

import com.leysoft.axon.infrastructure.persistence.entity.PersonEntity

interface PersonRepository {

    fun findById(id: String): PersonEntity?

    fun save(entity: PersonEntity): Unit
}
