package com.ohashi.contentmanagement.domain.factories

import com.ohashi.contentmanagement.domain.entities.Author
import com.ohashi.contentmanagement.domain.entities.Content

object AuthorFactory {
    fun sample(): Author = Author(
        null,
        "Dummy",
        "dummy@email.com",
        "linkedin.com.br",
        listOf(
            Content(
                "title",
                "subtitle",
                "conte.com"
            )
        )
    )

    fun sampleList(): List<Author> = listOf<Author>(
        Author(
            null,
            "Dummy",
            "dummy@email.com",
            "linkedin.com.br",
            listOf(
                Content(
                    "title",
                    "subtitle",
                    "conte.com"
                )
            )
        )
    )
}