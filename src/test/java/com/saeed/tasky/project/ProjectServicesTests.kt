package com.saeed.tasky.project

import com.saeed.tasky.models.Project
import com.saeed.tasky.models.User
import com.saeed.tasky.models.dto.ProjectDto
import com.saeed.tasky.services.ProjectServices
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ProjectServicesTests {

    @Autowired
    lateinit var services: ProjectServices

    @Test
    fun `get all projects test`() {
        val result = services.allProjects
        assertThat(result).isNotEmpty
        assertThat(result.size).isGreaterThan(0)
    }

    @Test
    fun `get projects with all info test`() {
        val result = services.projectAllInfo
        assertThat(result).isNotEmpty
        assertThat(result.size).isGreaterThan(0)
    }

    @Test
    fun `Add project test`() {
        val dto = ProjectDto()
        val name = "name of project3"
        dto.name = name
        dto.user = services.userServices.users[2] as User?
        dto.role = services.getRoleByName("admin")

        val result = services.addProject(dto)
        assertThat(result.project!!.name).isEqualTo(name)
    }

}
