package com.demo.lidl.repository

enum class DeliveryStatus(val status: String) {
    WAITING("waiting"),
    IN_TRANSIT("in_transit"),
    DELIVERED("delivered"),
}

enum class PickStatus(){
    WAITING,
    PICKED
}

enum class Priority() {
    P0,
    P1,
    P2,
    P3
}

enum class DamageStatus() {
    MINT,
    NEAR_MINT,
    VERY_GOOD,
    GOOD,
    POOR
}