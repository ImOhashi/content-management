package com.ohashi.contentmanagement.application.web.controllers

import com.ohashi.contentmanagement.application.payloads.AuthorResponse
import com.ohashi.contentmanagement.domain.entities.Author
import com.ohashi.contentmanagement.domain.services.AuthorService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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
    fun getAllAuthors(): ResponseEntity<List<AuthorResponse>> =
        ResponseEntity.ok(this.authorService.getAllAuthor().map { AuthorResponse(it) })

    @PostMapping
    fun createAuthor(
        @RequestBody @Valid author: Author,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<AuthorResponse> {
        logger.info("Requested create author: ${author.toString()}")

        val createdAuthor = this.authorService.create(author)

        val uri = uriComponentsBuilder.path("/author/").buildAndExpand(createdAuthor.fullname).toUri()

        return ResponseEntity.created(uri).body(AuthorResponse(createdAuthor))
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(AuthorController::class.java)
    }
}