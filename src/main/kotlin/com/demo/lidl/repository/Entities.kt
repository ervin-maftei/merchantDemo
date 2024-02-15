package com.demo.lidl.repository

import com.demo.lidl.repository.DamageStatus.MINT
import com.demo.lidl.repository.DeliveryStatus.WAITING
import com.demo.lidl.repository.Priority.P2
import jakarta.persistence.*


@Entity
data class Container(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = 0,
    var quantity: Long = 0,
    var weight: Long = 4,
    var height: Long = 4,
    var damageStatus: DamageStatus = MINT,
)

@Entity
data class Driver(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = 0,
    var name: String = "john doe"
)

@Entity
data class ContainerEvent(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = 0,
    var pickStatus: PickStatus = PickStatus.WAITING,
    var deliveryStatus: DeliveryStatus = WAITING,
    var gasFreeMeasure: Long = 0,
    var pin: String = "1234",
    var priority: Priority = P2,
    @ManyToOne
    var driver: Driver = Driver(0, "john doe"),
    @OneToOne
    var container: Container = Container(
        1,
        100,
        4,
        5,
        MINT
    )
)
