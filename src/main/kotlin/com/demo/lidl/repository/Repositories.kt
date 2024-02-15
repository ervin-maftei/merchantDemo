package com.demo.lidl.repository

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

@EnableJpaRepositories
interface ContainerRepository : JpaRepository<Container, Long> {
    fun getContainerById(containerId: Long): Container
}

@EnableJpaRepositories
interface ContainerEventRepository : JpaRepository<ContainerEvent, Long> {
    @Modifying(flushAutomatically = true)
    @Transactional
    @Query(
        value = "update ContainerEvent ce set ce.driver = :driver where ce.id = :containerEventId"
    )
    fun updateContainerEventDriverById(
        @Param("containerEventId") containerEventId: Long,
        @Param("driver") driver: Driver
    ): Int



    fun getContainerEventById(containerEventId: Long): ContainerEvent
    fun getContainerEventsByPickStatus(pickStatus: PickStatus): List<ContainerEvent>
}

@EnableJpaRepositories
interface DriverRepository : CrudRepository<Driver, Long>
