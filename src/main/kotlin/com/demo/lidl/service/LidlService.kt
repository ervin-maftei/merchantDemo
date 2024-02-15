package com.demo.lidl.service

import com.demo.lidl.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LidlService(
    @Autowired private val driverRepository: DriverRepository,
    @Autowired private val containerRepository: ContainerRepository,
    @Autowired private val containerEventRepository: ContainerEventRepository
) {

    fun createDrivers(drivers: List<Driver>) {
        driverRepository.saveAll(drivers)
    }

    fun getDrivers(): List<Driver> {
        return driverRepository.findAll().iterator().asSequence().toList()
    }

    fun createContainers(containers: List<Container>) {
        containerRepository.saveAll(containers)
    }
    fun getContainers(): List<Container> {
        return containerRepository.findAll().iterator().asSequence().toList()
    }

    fun createContainerEvents(containerEvents: List<ContainerEvent>) {
        containerEventRepository.saveAll(containerEvents)
    }

    fun getContainerEvents(): List<ContainerEvent> {
        return containerEventRepository.findAll().iterator().asSequence().toList()
    }

    fun updateContainerEventDriverById(id: Long, driver: Driver) {
        containerEventRepository.updateContainerEventDriverById(id, driver)
    }
}