package com.destiny.card.model

import io.crnk.core.resource.annotations.*
import javax.persistence.*

@Entity
data class Card(
        @Id @GeneratedValue @JsonApiId var id: Int = 0,

        var number: Int = 0,
        var name: String = "",
        var title: String? = null,
        var text: String? = null,
        var quote: String? = null,
        var cost: Int? = null,
        var points: String? = null,
        var health: Int? = null,

        @Enumerated(EnumType.STRING) var affiliation: Affiliation? = Affiliation.NEUTRAL,
        @Enumerated(EnumType.STRING) var faction: Faction = Faction.NEUTRAL,
        @Enumerated(EnumType.STRING) var type: Type = Type.BATTLEFIELD,
        @Enumerated(EnumType.STRING) var rarity: Rarity = Rarity.COMMON,

        @ManyToOne @JoinColumn(name = "set_id") var set: Set = Set()
)