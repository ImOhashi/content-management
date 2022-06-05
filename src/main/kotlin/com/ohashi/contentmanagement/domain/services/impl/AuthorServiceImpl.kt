package com.ohashi.contentmanagement.domain.services.impl

import com.ohashi.contentmanagement.domain.entities.Author
import com.ohashi.contentmanagement.domain.repositories.AuthorRepository
import com.ohashi.contentmanagement.domain.services.AuthorService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository
) : AuthorService {
    override fun getAllAuthor(): List<Author> = this.authorRepository.findAll().let {
        logger.info("Calling getAllAuthors service to trying return registered authors.")

        if (it.size == 0) {
            logger.error("Don't have any author registered.")
            throw Exception("Don't have any author registered.")
        }

        logger.info("Returning authors.")
        return it
    }

    override fun create(author: Author): Author {
        logger.info("Calling create service to trying create a new author.")

        this.authorRepository.findByEmail(author.email).let {
            if (it != null) {
                logger.error("Author already registered!")
                throw Exception("Author already registered!")
            }
        }

        return this.authorRepository.save(author).also {
            logger.info("Author ${author.fullname} has been registered!")
        }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(AuthorService::class.java)
    }
}