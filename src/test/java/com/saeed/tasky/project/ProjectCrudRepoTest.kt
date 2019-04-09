package com.saeed.tasky.project

import com.saeed.tasky.models.Project
import com.saeed.tasky.repositories.ProjectRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.annotation.Order
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class ProjectCrudRepoTest {

    @Autowired
    lateinit var repository: ProjectRepository

    @Test(expected = NullPointerException::class)
    @Order(value = 1)
    fun `add null project test`() {
        val entity: Project? = null
        repository.save(entity!!)
    }

    @Test
    @Order(value = 2)
    fun `add a project, must be successful`() {
        val name = "project projectName"
        val icon = "project icon"

        val entity = Project(name = name, icon = icon)
        val result = repository.save(entity)
        assertThat(result.name).isEqualTo(name)
        assertThat(result.icon).isEqualTo(icon)
    }

    @Test
    @Order(value = 3)
    fun `add a project and find it, must be successful`() {
        val name = "project projectName"
        val icon = "project icon"

        val entity = Project(name = name, icon = icon)
        repository.save(entity)
        val result = repository.findAll() as MutableList<Project>
        val s = result.size
        assertThat(s).isGreaterThan(0)
        assertThat(result[s-1].name).isEqualTo(name)
        assertThat(result[s-1].icon).isEqualTo(icon)
    }

    @Test
    @Order(value = 4)
    fun `add a project and find it by Id, must be successful`() {
        val name = "project projectName"
        val icon = "project icon"

        val entity = Project(name = name, icon = icon)
        val originObj =  repository.save(entity)
        val savedObj = repository.findProjectById(originObj.id!!)
        assertThat(savedObj.name).isEqualTo(name)
        assertThat(savedObj.icon).isEqualTo(icon)
    }

    @Test
    @Order
    fun `Delete item by name`() {
        val name = "project projectName"
        val result = repository.removeByName(name)
        assertThat(result).isNotEmpty

    }

}