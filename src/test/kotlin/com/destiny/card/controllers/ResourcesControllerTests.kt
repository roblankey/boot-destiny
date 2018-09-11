package com.destiny.card.controllers

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ResourcesControllerTests {

    @Autowired
    lateinit var template: TestRestTemplate

    @Test
    fun showsCardAndSetResources() {
        val result = template.getForEntity("/resources", Map::class.java)
        assertEquals(200, result.statusCodeValue)
        assertTrue(result.body!!.contains("card"))
        assertTrue(result.body!!.contains("set"))
    }

    @Test
    fun showsNoMetaResources() {
        val result = template.getForEntity("/resources", Map::class.java)
        assertEquals(200, result.statusCodeValue)
        result.body!!.keys.forEach {
            assertTrue(it is String)
            assertFalse(it.toString().startsWith("meta"))
        }
    }

}