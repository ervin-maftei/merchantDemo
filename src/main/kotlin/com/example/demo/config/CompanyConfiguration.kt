package com.example.demo.config

import com.example.demo.domain.Discipline
import com.example.demo.domain.Grade
import com.example.demo.repository.Person
import com.example.demo.repository.PersonRepository
import com.example.demo.repository.Project
import com.example.demo.repository.ProjectRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class CompanyConfiguration {
    @Bean
    open fun databaseInit(personRepository: PersonRepository,
                          projectRepository: ProjectRepository) = ApplicationRunner {
        persistProjects(projectRepository)
        persistPersons(personRepository, projectRepository)

    }

    private fun persistProjects(projectRepository: ProjectRepository) {
        projectRepository.save(Project(null, "vocalink", "payments"))
        projectRepository.save(Project(null, "nets", "payments"))
        projectRepository.save(Project(null, "DTag", "telecom"))
        projectRepository.save(Project(null, "HealthIns", "insurance"))
    }

    private fun persistPersons(personRepository: PersonRepository,
                               projectRepository: ProjectRepository) {
        personRepository.save(
            Person(
                id = null,
                firstName = "ervin",
                lastName = "maftei",
                grade = Grade.SE,
                discipline = Discipline.DEV,
                projects = listOf(projectRepository.findByName("vocalink"))
            )
        )
        personRepository.save(
            Person(
                id = null,
                firstName = "laur",
                lastName = "laurr",
                grade = Grade.SE,
                discipline = Discipline.TEST,
                projects = listOf(projectRepository.findByName("vocalink"))
            )
        )
        personRepository.save(
            Person(
                id = null,
                firstName = "john",
                lastName = "doe",
                grade = Grade.CL,
                discipline = Discipline.OPS,
                projects = listOf(projectRepository.findByName("DTag"))
            )
        )
        personRepository.save(
            Person(
                id = null,
                firstName = "andreea",
                lastName = "andrew",
                grade = Grade.JT,
                discipline = Discipline.SM,
                projects = listOf(projectRepository.findByName("vocalink"),
                    projectRepository.findByName("HealthIns"))
            )
        )
        personRepository.save(
            Person(
                id = null,
                firstName = "mini",
                lastName = "mainy",
                grade = Grade.ST,
                discipline = Discipline.DEV,
                projects = listOf(projectRepository.findByName("nets"))
            )
        )
    }
}