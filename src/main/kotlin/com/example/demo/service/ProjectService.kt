package com.example.demo.service

import com.example.demo.domain.ProjectDto
import com.example.demo.repository.Person
import com.example.demo.repository.PersonRepository
import com.example.demo.repository.Project
import com.example.demo.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService(
    @Autowired private val projectRepository:ProjectRepository,
    @Autowired private val personRepository: PersonRepository,
    var projects: MutableList<ProjectDto> = mutableListOf()) {

    init {
        this.projects = mutableListOf(

            ProjectDto(
                "project1", "payments", listOf(
                    "Mihai",
                    "Alin",
                    "Vasile"
                )
            ),
            ProjectDto(
                "project2", "payments", listOf(
                    "Ion",
                    "Ioana",
                    "Ionela",
                )
            ),
            ProjectDto(
                "project3", "automotive", listOf(
                    "Iony",
                    "Gina",
                    "Ervin",
                    "Mirel",
                    "Pisi"
                )
            ),
            ProjectDto(
                "project4", "gaming", listOf(
                    "Marius"
                )
            ),
            ProjectDto(
                "project5", "gaming", listOf(
                    "Marius",
                    "Lorena"
                )
            )
        )
    }

    fun getByIndustry(industry: String): List<ProjectDto> {
        val projectDtos: List<ProjectDto> = arrayListOf()
        for (projectDto: ProjectDto in this.projects) {
            if (projectDto.industry == industry) {
                projectDtos.addLast(projectDto)
            }
        }
        return projectDtos;
    }

    fun getByIndustryFromDb(industry: String): List<Project> {
        return projectRepository.findAllByIndustry(industry)
    }

    fun getAll(): List<Project> {
        return projectRepository.getAll()
    }

    fun findPersonByFirstName(firstName: String): Person {
        return personRepository.findByFirstName(firstName)
    }
}