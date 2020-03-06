package com.leysoft.axon.domain.command

import com.leysoft.axon.core.Command
import java.time.ZonedDateTime
import java.util.UUID
import org.axonframework.modelling.command.TargetAggregateIdentifier

data class CreatePerson(
    @TargetAggregateIdentifier val id: String = UUID.randomUUID().toString(),
    val name: String,
    val createdAt: ZonedDateTime = ZonedDateTime.now()
) : Command {

    override fun id(): String = this.id

    override fun createdAt(): ZonedDateTime = this.createdAt
}
