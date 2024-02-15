package com.example.demo.api

import com.example.demo.domain.ProjectDto
import com.example.demo.repository.Person
import com.example.demo.repository.Project
import com.example.demo.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProjectController(@Autowired val service: ProjectService) {

//    @GetMapping("/getAll")
//    fun getProjects(): MutableList<ProjectDto> {
//        return service.projects
//    }

    @GetMapping("/getByIndustry/{industry}")
    fun getByIndustry(@PathVariable("industry") industry: String): List<ProjectDto> {
        return service.getByIndustry(industry)
    }

    @GetMapping("/findAllByIndustry/{industry}")
    fun findAllByIndustry(@PathVariable("industry") industry: String): List<Project> {
        return service.getByIndustryFromDb(industry)
    }

    @GetMapping("/getAll")
    fun getHtmlAllByIndustry(): List<Project> {
        return service.getAll()
    }

    @GetMapping("/getPersonByFirstName/{firstName}")
    fun getPersonByFirstName(@PathVariable("firstName") firstName : String): Person {
        return service.findPersonByFirstName(firstName)
    }
}