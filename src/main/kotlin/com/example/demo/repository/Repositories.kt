package com.example.demo.repository

import com.example.demo.domain.Discipline
import com.example.demo.domain.Grade
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.CrudRepository

@EnableJpaRepositories
interface PersonRepository : CrudRepository<Person, Long> {
    fun findAllByGrade(grade: Grade): List<Person>
    fun findByFirstName(firstName: String): Person
    fun findAllByDiscipline(discipline: Discipline): List<Person>
}

@EnableJpaRepositories
interface ProjectRepository : CrudRepository<Project, Long> {
    fun findByName(name: String): Project
    fun findAllByIndustry(name: String): List<Project>
    @Query(value = "SELECT * from PROJECT" , nativeQuery = true)
    fun getAll(): List<Project>
}