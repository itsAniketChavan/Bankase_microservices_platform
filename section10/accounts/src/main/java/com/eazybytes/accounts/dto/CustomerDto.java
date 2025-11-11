package com.eazybytes.accounts.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty
    @Size(min=5, max = 30, message = "name length should in between 5 - 30")
    private String name;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
