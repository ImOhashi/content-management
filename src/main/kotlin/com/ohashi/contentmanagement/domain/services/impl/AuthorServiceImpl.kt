package com.ohashi.contentmanagement.domain.services.impl

import com.ohashi.contentmanagement.domain.entities.Author
import com.ohashi.contentmanagement.domain.repositories.AuthorRepository
import com.ohashi.contentmanagement.domain.services.AuthorService
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository
) : AuthorService {
    override fun getAllAuthor(): List<Author> = this.authorRepository.findAll().let {
        if (it.size == 0) {
            throw Exception("Não existem autores cadastrados.")
        }

        return it
    }

    override fun create(author: Author): Author {
        this.authorRepository.findByEmail(author.email).let {
            if (it != null)
                throw Exception("Autor já cadastrado!")
        }

        return this.authorRepository.save(author)
    }
}