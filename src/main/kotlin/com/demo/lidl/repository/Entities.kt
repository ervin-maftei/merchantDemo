package com.demo.lidl.repository

import jakarta.persistence.*


@Entity
data class Container(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = null,
    var quantity: Long? = null,
    var weight: Long? = null,
    var height: Long? = null,
    var damageStatus: DamageStatus? = null
)

@Entity
data class Driver(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = null,
    var name: String? = null
)

@Entity
data class ContainerEvent(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = null,
    var pickStatus: PickStatus? = null,
    var deliveryStatus: DeliveryStatus? = null,
    var gasFreeMeasure: Long? = null,
    var pin: String? = null,
    var priority: Priority? = null,
    @ManyToOne
    var driver: Driver? = null,
    @OneToOne
    var container: Container? = null
)
