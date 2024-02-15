package com.example.demo.repository

import com.example.demo.domain.Discipline
import com.example.demo.domain.Grade
import jakarta.persistence.*

@Entity
@Table(name = "PERSON")
data class Person(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = 0,
    var firstName: String = "default",
    var lastName: String = "default",
    var grade: Grade = Grade.JT,
    var discipline: Discipline = Discipline.DEV,
    @ManyToMany var projects: List<Project> = listOf(Project(0, "", ""))
)

@Entity
data class Project(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = 0,
    var name: String = "default",
    var industry: String = "default",
)