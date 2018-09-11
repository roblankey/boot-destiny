package com.destiny.card.model

import io.crnk.core.resource.annotations.JsonApiId
import javax.persistence.*

@Entity
@Table(name = "card_set")
data class Set(
        @Id @GeneratedValue @JsonApiId var id: Int = 0,

        var name: String = "",
        var icon: String? = null
) {
    @OneToMany(mappedBy = "set") var cards: List<Card>? = emptyList()
}