package com.leysoft.axon.infrastructure.persistence.repository

import com.leysoft.axon.infrastructure.persistence.entity.PersonEntity
import org.springframework.stereotype.Repository

@Repository
class InMemoryPersonRepository : PersonRepository {

    private val map = mutableMapOf<String, PersonEntity>()

    override fun findById(id: String): PersonEntity? = map[id]

    override fun save(entity: PersonEntity) {
        map[entity.id] = entity
    }
}
