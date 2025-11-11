package com.eazybytes.accounts.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data

public class AccountsDto {

    @NotEmpty(message = "Account number should be provided")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number should be 10 digit")
    private Long accountNumber;

    @NotEmpty(message = "Account type should be provided")
    private String accountType;

    @NotEmpty(message = "Branch address should be provided")
    private String branchAddress;
}
