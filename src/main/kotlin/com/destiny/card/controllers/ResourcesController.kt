package com.destiny.card.controllers

import io.crnk.core.engine.registry.ResourceRegistry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Configuration
@RestController
class ResourcesController {
    @Autowired
    private val resourceRegistry : ResourceRegistry? = null

    @GetMapping("/resources")
    fun getResources() : Map<String, String> {
        val result = HashMap<String, String>()
        resourceRegistry!!.resources.forEach {
            val key = it.resourceInformation.resourceType
            val value = resourceRegistry.getResourceUrl(it.resourceInformation)
            if (!key.startsWith("meta")) result[key] = value
        }
        return result
    }
}