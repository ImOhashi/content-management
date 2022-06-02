package com.ohashi.contentmanagement.domain.services

import com.ohashi.contentmanagement.domain.entities.Author

interface AuthorService {
    fun getAllAuthor(): List<Author>
}