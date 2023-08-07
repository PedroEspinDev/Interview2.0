package com.example.TechnicalInterview.resources;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Builder
@Getter
@Setter
public class TeamResource {
    private Long id;
    @NotBlank(message = "name is required")
    private String name;

    private String city;

    private String owner;

    @Positive
    private Integer stadiumCapacity;

    @Max(3)
    @Min(1)
    private Integer division;

    private String competition;

    @Positive
    private Integer numberOfPlayers;
}
