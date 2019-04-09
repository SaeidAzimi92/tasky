package com.saeed.tasky.project

import com.saeed.tasky.models.dto.ProjectRootsDto
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
        val name = "projectName of project4"
        dto.projectName = name
        dto.projectIcon = "ssd.fgg"
        dto.user = services.getUser(17)
        dto.role = services.getRoleByName("admin")

        val result = services.addProject(dto)
        assertThat(result.projectName).isEqualTo(name)
    }

// change : at first add a project @Before and save its id and then called these tests
    @Test
    fun `get project members by project-id`(){
        val pId: Long = 161
        val result = services.getProjectMembers(pId)
        assertThat(result).isNotEmpty
    }

    @Test
    fun `add a developer to project`(){
        val project = services.getProjectById(161)
        val user = services.getUser(146)
        val role = services.getRoleById(4)
        val dto = ProjectRootsDto(projectId = project.id,projectName = project.name,
                userId = user.id, userName = user.firstName,roleId = role.id, roleName = role.name)
        val result = services.addMemberToProject(dto)
        assertThat(result).isTrue()
    }
}