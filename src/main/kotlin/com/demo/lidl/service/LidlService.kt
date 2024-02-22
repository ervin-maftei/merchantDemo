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
                quantity = container.quantity?: containerDbObj.quantity,
                weight = container.weight?: containerDbObj.weight,
                height = container.height?: containerDbObj.weight,
                damageStatus = container.damageStatus?: containerDbObj.damageStatus
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
                pickStatus = containerEvent.pickStatus?: containerEventDbObj.pickStatus,
                deliveryStatus = containerEvent.deliveryStatus?: containerEventDbObj.deliveryStatus,
                gasFreeMeasure = containerEvent.gasFreeMeasure?: containerEventDbObj.gasFreeMeasure,
                pin = containerEvent.pin?: containerEventDbObj.pin,
                priority = containerEvent.priority?: containerEventDbObj.priority,
                driver = containerEvent.driver?: containerEventDbObj.driver,
                container = containerRepository.findById(containerEvent.container?.id?: 0).orElse(containerEventDbObj.container)
            )
        )
    }
}