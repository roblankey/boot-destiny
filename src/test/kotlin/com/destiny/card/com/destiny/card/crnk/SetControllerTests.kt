package com.destiny.card.com.destiny.card.crnk

import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SetControllerTests {

    @Autowired
    lateinit var template: TestRestTemplate

    @Test
    fun getReturnsSets() {
        val result = template.getForEntity("/set", String::class.java)
        Assert.assertEquals(200, result.statusCodeValue)

        val data = JsonParser().parse(result.body).asJsonObject.get("data").asJsonArray
        Assert.assertTrue(data.any())
        Assert.assertEquals("Awakenings", data[0].asJsonObject.get("attributes").asJsonObject.get("name").asString)
    }

    @Test
    fun getSingleReturnsSet() {
        val result = template.getForEntity("/set/1", String::class.java)
        Assert.assertEquals(200, result.statusCodeValue)

        val data = JsonParser().parse(result.body).asJsonObject.get("data").asJsonObject
        Assert.assertNotNull(data)
        Assert.assertEquals("Awakenings", data.get("attributes").asJsonObject.get("name").asString)
    }

}