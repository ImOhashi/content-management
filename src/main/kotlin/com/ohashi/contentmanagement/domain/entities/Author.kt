package com.ohashi.contentmanagement.domain.entities

import lombok.AllArgsConstructor
import lombok.Data
import lombok.Generated
import lombok.NoArgsConstructor
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Document("Author")
data class Author(
    val _id: ObjectId?,

    @NotNull
    val fullname: String,

    @NotNull
    @NotEmpty
    val email: String,

    @NotNull
    @NotEmpty
    val linkedinUrl: String,

    @NotNull
    val content: List<Content>
)