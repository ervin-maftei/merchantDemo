package com.demo.lidl.api

import com.demo.lidl.repository.Container
import com.demo.lidl.repository.ContainerEvent
import com.demo.lidl.repository.Driver
import com.demo.lidl.service.LidlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/add")
class LidlAddController(@Autowired val lidlService: LidlService) {

    @PostMapping("/drivers")
    fun addDriver(@RequestBody drivers: List<Driver>) {
        lidlService.createDrivers(drivers)
    }

    @PostMapping("/containers")
    fun addContainers(@RequestBody containers: List<Container>) {
        lidlService.createContainers(containers)
    }

    @PostMapping("/containerEvents")
    fun addContainerEvents(@RequestBody containerEvents: List<ContainerEvent>) {
        lidlService.createContainerEvents(containerEvents)
    }
}

@RestController
@RequestMapping("/get")
class LidlReadController(@Autowired val lidlService: LidlService) {

    @GetMapping("/drivers")
    fun getAllDrivers(): List<Driver> {
        return lidlService.getDrivers()
    }

    @GetMapping("/containers")
    fun getAllContainers(): List<Container> {
        return lidlService.getContainers()
    }

    @GetMapping("/containerEvents")
    fun getAllContainerEvents(): List<ContainerEvent> {
        return lidlService.getContainerEvents()
    }
}

@RestController
@RequestMapping("/update")
class LidlUpdateController(@Autowired val lidlService: LidlService) {

    @PatchMapping("/containerEvent/{id}")
    fun patchContainerEvent(@PathVariable id: Long, @RequestBody driver:Driver) {
        lidlService.updateContainerEventDriverById(id, driver)
    }
}