package com.riyaz.RestApiExample.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class AddStudentReqDto {
    @NotBlank(message = "name is required")
    @Size(min = 3,max = 30 , message = "name should be of 3 to 30 chars length")
    private String name;

    @Email
    @NotBlank(message = "Email cannot be blank")
    private String email;
}
