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
    fun getDrivers(): List<Driver> {
        return driverRepository.findAll().iterator().asSequence().toList()
    }

    fun getContainers(): List<Container> {
        return containerRepository.findAll().iterator().asSequence().toList()
    }

    fun getContainerEvents(): List<ContainerEvent> {
        return containerEventRepository.findAll().iterator().asSequence().toList()
    }
}