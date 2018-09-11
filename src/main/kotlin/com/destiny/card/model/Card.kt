package com.destiny.card.model

import io.crnk.core.resource.annotations.*
import org.hibernate.annotations.Formula
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
        @Enumerated(EnumType.STRING) var rarity: Rarity = Rarity.COMMON
) {
    @OneToOne(mappedBy = "card", fetch = FetchType.LAZY) var die: Die? = null
    @ManyToOne @JoinColumn(name = "set_id") var set: Set = Set()

    @Formula("(select group_concat(f.type || ifnull(' ' || f.value, '') || ifnull(' [' || f.cost || ']', ''), ', ') from die_face df, face f where df.die_id = id and df.face_id = f.id)")
    var dieSides: String? = null
}