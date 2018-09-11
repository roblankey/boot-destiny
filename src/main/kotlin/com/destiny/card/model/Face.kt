package com.destiny.card.model

import io.crnk.core.resource.annotations.JsonApiId
import javax.persistence.*

@Entity
data class Face(
        @Id @GeneratedValue @JsonApiId var id: Int = 0,

        @Enumerated(EnumType.STRING) var type: Symbol = Symbol.BLANK,
        var value: Int? = null,
        var cost: Int? = null
) {
    @ManyToMany(mappedBy = "sides") var dice: List<Die> = emptyList()
}