package com.ohashi.contentmanagement.domain.entities

import lombok.AllArgsConstructor
import lombok.Data
import lombok.Generated
import lombok.NoArgsConstructor
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
data class Content(
    @NotNull
    val title: String,

    @NotNull
    val subtitle: String,

    @NotNull
    @NotEmpty
    val url: String
)
