package com.destiny.card.model

import io.crnk.core.resource.annotations.JsonApiId
import org.hibernate.annotations.Formula
import javax.persistence.*

@Entity
data class Die(
        @Id @JsonApiId var id: Int = 0,

        @ManyToMany
        @JoinTable(name = "die_face", joinColumns = [JoinColumn(name = "die_id")], inverseJoinColumns = [JoinColumn(name = "face_id")])
        var sides: List<Face> = emptyList(),

        @OneToOne(fetch = FetchType.LAZY) @MapsId var card: Card = Card()
) {
    @Formula("(select group_concat(f.type || ifnull(' ' || f.value, '') || ifnull(' [' || f.cost || ']', ''), ', ') from die_face df, face f where df.die_id = card_id and df.face_id = f.id)")
    var allSides: String? = null
}