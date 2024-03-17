package com.bookmanagement.bookmanagement.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class BookTitleDTO {
    @NotEmpty(message = "the title cannot be empty ")
    private String title;
}
