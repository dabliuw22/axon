package com.leysoft.axon.domain.command

import com.leysoft.axon.core.Command
import org.axonframework.modelling.command.TargetAggregateIdentifier

data class CreatePerson(@TargetAggregateIdentifier val id: String, val name: String): Command