package com.ohashi.contentmanagement.domain.services

import assertk.assertThat
import assertk.assertions.hasMessage
import assertk.assertions.isEqualTo
import assertk.assertions.isFailure
import com.ohashi.contentmanagement.domain.entities.Author
import com.ohashi.contentmanagement.domain.factories.AuthorFactory
import com.ohashi.contentmanagement.domain.repositories.AuthorRepository
import com.ohashi.contentmanagement.domain.services.impl.AuthorServiceImpl
import io.mockk.*
import org.junit.jupiter.api.*

class AuthorServiceTest {

    private val authorRepository = mockk<AuthorRepository>()

    private lateinit var authorService: AuthorService

    @BeforeEach
    fun setup() {
        clearAllMocks()

        authorService = AuthorServiceImpl(authorRepository)
    }

    @Test
    @DisplayName("Test getAllAuthor - success")
    fun `should be return an array of authors`() {
        val authorListMock = AuthorFactory.sampleList()

        every {
            authorRepository.findAll()
        } returns authorListMock

        val authorList = authorService.getAllAuthor()

        verify(exactly = 1) {
            authorRepository.findAll()
        }

        assertThat(authorListMock.size).isEqualTo(authorList.size)
    }

    @Test
    @DisplayName("Test getAllAuthor - exception")
    fun `should be not return any results`() {
        every {
            authorRepository.findAll()
        } returns listOf()

        assertThrows<Exception> {
            authorService.getAllAuthor()
        }
    }

    @Test
    @DisplayName("Test create - success")
    fun `should be create a new author`() {
        val author = AuthorFactory.sample()

        every {
            authorRepository.findByEmail(author.email)
        } returns null

        every {
            authorRepository.save(author)
        } returns author

        val newAuthor = authorService.create(author)

        verify(exactly = 1) {
            authorRepository.findByEmail(author.email)
        }

        assertThat(author).isEqualTo(newAuthor)
    }

    @Test
    @DisplayName("Test create - exception")
    fun `should be not create a new user and throw exception`() {
        val author = AuthorFactory.sample()

        every {
            authorRepository.findByEmail(author.email)
        } returns author

        assertThrows<Exception> {
            authorService.create(author);
        }
    }
}