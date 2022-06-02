package com.ohashi.contentmanagement.application.web.controllers

import com.ohashi.contentmanagement.domain.entities.Author
import com.ohashi.contentmanagement.domain.services.AuthorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("author")
class AuthorController(
    private val authorService: AuthorService
) {
    @GetMapping
    fun getAllAuthors(): ResponseEntity<List<Author>> = ResponseEntity.ok(this.authorService.getAllAuthor())

    @PostMapping
    fun createAuthor(@RequestBody @Valid author: Author, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<Author> {
        val createdAuthor = this.authorService.create(author)

        val uri = uriComponentsBuilder.path("/author/").buildAndExpand(createdAuthor.fullname).toUri()

        return ResponseEntity.created(uri).body(createdAuthor)
    }
}