package com.demo.lidl.api

import com.demo.lidl.repository.Container
import com.demo.lidl.repository.ContainerEvent
import com.demo.lidl.repository.Driver
import com.demo.lidl.service.LidlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LidlController(@Autowired val lidlService: LidlService) {

    @GetMapping("/getAll/drivers")
    fun getAllDrivers(): List<Driver> {
        return lidlService.getDrivers()
    }

    @GetMapping("/getAll/containers")
    fun getAllContainers(): List<Container> {
        return lidlService.getContainers()
    }

    @GetMapping("/getAll/containerEvents")
    fun getAllcontainerEvents(): List<ContainerEvent> {
        return lidlService.getContainerEvents()
    }
}