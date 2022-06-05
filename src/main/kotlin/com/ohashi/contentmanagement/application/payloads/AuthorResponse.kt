package com.ohashi.contentmanagement.application.payloads

import com.ohashi.contentmanagement.domain.entities.Author
import com.ohashi.contentmanagement.domain.entities.Content

data class AuthorResponse(
    val fullname: String,
    val email: String,
    val linkedinUrl:String,
    val content: List<Content>
) {
    constructor(author: Author) : this(
        fullname = author.fullname,
        email = author.email,
        linkedinUrl = author.linkedinUrl,
        content = author.content
    )
}
