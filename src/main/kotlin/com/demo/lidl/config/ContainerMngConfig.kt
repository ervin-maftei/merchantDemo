package com.demo.lidl.config

import com.demo.lidl.repository.*
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ContainerMngConfig {
    @Bean
    open fun databaseInit(
        driverRepository: DriverRepository,
        containerRepository: ContainerRepository,
        containerEventRepository: ContainerEventRepository
    ) = ApplicationRunner {

        createDrivers(driverRepository)

        createContainers(containerRepository)

        containerEventRepository.save(
            ContainerEvent(
                1,
                pickStatus = PickStatus.WAITING,
                deliveryStatus = DeliveryStatus.WAITING,
                gasFreeMeasure = 0,
                pin = "2222",
                priority = Priority.P1,
                driver = driverRepository.findById(1).get(),
                container = containerRepository.getContainerById(1)
            )
        )
        containerEventRepository.save(
            ContainerEvent(
                id = 2,
                pickStatus = PickStatus.PICKED,
                deliveryStatus = DeliveryStatus.IN_TRANSIT,
                gasFreeMeasure = 0,
                pin = "2222",
                priority = Priority.P1,
                driver = driverRepository.findById(2).get(),
                container = containerRepository.getContainerById(2)
            )
        )
    }

    private fun createContainers(containerRepository: ContainerRepository) {
        containerRepository.save(Container(1, 100,5,5, DamageStatus.MINT))
        containerRepository.save(Container(2, 400))
        containerRepository.save(Container(3, 1000, 6, 8))
        containerRepository.save(Container(4, 900,7, 9))
        containerRepository.save(Container(5, 500))
        containerRepository.save(Container(6, 500))
        containerRepository.save(Container(7, 1000, 6, 8))
        containerRepository.save(Container(8, 200))
    }

    private fun createDrivers(driverRepository: DriverRepository) {
        driverRepository.save(Driver(1, "driver1"))
        driverRepository.save(Driver(2, "driver2"))
        driverRepository.save(Driver(3, "driver3"))
        driverRepository.save(Driver(4, "driver4"))
    }
}