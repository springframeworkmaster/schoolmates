package com.services.schoolmates.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolmateDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String currentCity;

    private String profession;

    private String comments;

    private String dob;
}
