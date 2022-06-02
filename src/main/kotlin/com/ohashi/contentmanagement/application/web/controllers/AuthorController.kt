package com.ohashi.contentmanagement.application.web.controllers

import com.ohashi.contentmanagement.domain.entities.Author
import com.ohashi.contentmanagement.domain.services.AuthorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("author")
class AuthorController(
    private val authorService: AuthorService
) {
    @GetMapping
    fun getAllAuthors(): ResponseEntity<List<Author>> = ResponseEntity.ok(this.authorService.getAllAuthor())
}