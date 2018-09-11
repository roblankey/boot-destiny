package com.destiny.card.com.destiny.card.crnk

import com.google.gson.JsonParser
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardControllerTests {

    @Autowired
    lateinit var template: TestRestTemplate

    @Test
    fun getReturnsCards() {
        val result = template.getForEntity("/card", String::class.java)
        assertEquals(200, result.statusCodeValue)

        val data = JsonParser().parse(result.body).asJsonObject.get("data").asJsonArray
        assertTrue(data.any())
        assertEquals("Captain Phasma", data[0].asJsonObject.get("attributes").asJsonObject.get("name").asString)
    }

    @Test
    fun getSingleReturnsCard() {
        val result = template.getForEntity("/card/1", String::class.java)
        assertEquals(200, result.statusCodeValue)

        val data = JsonParser().parse(result.body).asJsonObject.get("data").asJsonObject
        assertNotNull(data)
        assertEquals("Captain Phasma", data.get("attributes").asJsonObject.get("name").asString)
    }

}