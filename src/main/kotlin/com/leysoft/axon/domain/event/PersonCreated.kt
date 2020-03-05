package com.leysoft.axon.domain.event

import com.leysoft.axon.core.Event

data class PersonCreated(
    val id: String,
    val name: String
) : Event
