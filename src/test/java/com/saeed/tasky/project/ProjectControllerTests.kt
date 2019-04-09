package com.saeed.tasky.project

import com.saeed.tasky.controllers.ProjectController
import com.saeed.tasky.models.dto.ProjectRootsDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ProjectControllerTests {

    @Autowired
    lateinit var controller: ProjectController

    @Test
    fun `add a developer to project`(){
        val pId: Long = 9
        val uId: Long = 146
        val rId: Long = 4
        val dto = ProjectRootsDto(projectId = pId, userId = uId,roleId = rId)
        val result = controller.addUserToProjects(dto)
        assertThat(result).isEqualTo(HttpStatus.OK)
    }

}