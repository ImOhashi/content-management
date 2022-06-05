package com.ohashi.contentmanagement.application.web

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.ohashi.contentmanagement.application.web.controllers.AuthorController
import com.ohashi.contentmanagement.domain.factories.AuthorFactory
import com.ohashi.contentmanagement.domain.services.AuthorService
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.web.util.UriComponentsBuilder

class AuthorControllerTest {

    private val authorService = mockk<AuthorService>()

    private lateinit var authorController: AuthorController

    @BeforeEach
    fun setup() {
        clearAllMocks()

        authorController = AuthorController(authorService)
    }

    @Test
    @DisplayName("Test getAllAuthors - success")
    fun `should be return a all authors in response body`() {
        val authorsList = AuthorFactory.sampleList()

        every {
            authorService.getAllAuthor()
        } returns authorsList

        val response = authorController.getAllAuthors()

        assertThat(response.body).isEqualTo(authorsList)
    }

    @Test
    @DisplayName("Test createAuthor - success")
    fun `should be return a created author`() {
        val author = AuthorFactory.sample()

        every {
            authorService.create(author)
        } returns author

        val response = authorController.createAuthor(author, UriComponentsBuilder.newInstance())

        assertThat(response.body).isEqualTo(author)
    }
}