package com.bookmanagement.bookmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "the title cannot be empty ")
    private String title;
    private String author;
    private Integer publication_year;
    private String language;
    private BigDecimal price;
    @Max(value = 300, message = "The book quantity cannot be longer than 300")
    @Min(value = 10, message = "The book quantity cannot be less than 10")
    private Integer quantity;


};
