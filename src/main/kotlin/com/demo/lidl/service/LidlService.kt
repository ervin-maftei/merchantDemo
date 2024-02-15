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

    /*
   update the entire container with properties provided in request by path variable id.
   if property not provided, it will keep the db ones.
   for special relations (one to one, one to many etc) it is enough to provide only the corresponding id
    */
    //TODO: take care, it will actually override with the default values
    fun updateContainerById(containerId: Long, container: Container) {
        val containerDbObj = containerRepository.getContainerById(containerId)
        containerRepository.save(
            containerDbObj.copy(
                quantity = container.quantity,
                weight = container.weight,
                height = container.height,
                damageStatus = container.damageStatus
            )
        )
    }


    fun updateContainerEventDriverById(id: Long, driver: Driver) {
        containerEventRepository.updateContainerEventDriverById(id, driver)
    }

    /*
    update the entire container event with properties provided in request by path variable id.
    if property not provided, it will keep the db ones.
    for special relations (one to one, one to many etc) it is enough to provide only the corresponding id
     */
    //TODO: take care, it will actually override with the default values
    fun updateContainerEventById(id: Long, containerEvent: ContainerEvent) {
        val containerEventDbObj = containerEventRepository.findById(id).get()
        containerEventRepository.save(
            containerEventDbObj.copy(
                pickStatus = containerEvent.pickStatus,
                deliveryStatus = containerEvent.deliveryStatus,
                gasFreeMeasure = containerEvent.gasFreeMeasure,
                pin = containerEvent.pin,
                priority = containerEvent.priority,
                driver = containerEvent.driver,
                container = containerEvent.container
            )
        )
    }
}