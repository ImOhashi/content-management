package com.ohashi.contentmanagement.domain.services.impl

import com.ohashi.contentmanagement.domain.entities.Author
import com.ohashi.contentmanagement.domain.repositories.AuthorRepository
import com.ohashi.contentmanagement.domain.services.AuthorService
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository
) : AuthorService {
    override fun getAllAuthor(): List<Author> = authorRepository.findAll().let {
        if (it.size == 0) {
            throw Exception("Não existem autores cadastrados.")
        }

        return it
    }
}