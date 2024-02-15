package com.demo.lidl.repository

import com.example.demo.domain.Discipline
import com.example.demo.domain.Grade
import com.example.demo.repository.Person
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.CrudRepository

@EnableJpaRepositories
interface ContainerRepository : CrudRepository<Container, Long> {
    //fun updateContainerById(containerId: Long): Container
    fun getContainerById(containerId: Long): Container
}

@EnableJpaRepositories
interface ContainerEventRepository : CrudRepository<ContainerEvent, Long> {
    //fun updateContainerEventById(containerEventId: Long): ContainerEvent
    fun getContainerEventById(containerEventId: Long): ContainerEvent
    fun getContainerEventsByPickStatus(pickStatus: PickStatus): List<ContainerEvent>
}

@EnableJpaRepositories
interface DriverRepository : CrudRepository<Driver, Long>
