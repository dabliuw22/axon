package com.leysoft.axon.domain.event

import com.leysoft.axon.core.Event
import java.time.ZonedDateTime

data class PersonCreated(
    val id: String,
    val name: String,
    val createdAt: ZonedDateTime = ZonedDateTime.now()
) : Event {

    override fun id(): String = this.id

    override fun createdAt(): ZonedDateTime = this.createdAt
}
