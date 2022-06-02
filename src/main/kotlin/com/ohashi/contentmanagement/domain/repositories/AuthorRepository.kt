package com.ohashi.contentmanagement.domain.repositories

import com.ohashi.contentmanagement.domain.entities.Author
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : MongoRepository<Author, ObjectId> {
    fun findByEmail(email: String): Author?
}