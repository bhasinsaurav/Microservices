package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema representing account details"
)
public class AccountsDto {

    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{10})" , message = "Account Number must be 10 digits")
    @Schema(
            description = "Account number of the customer",
            example = "1234567890"
    )
    private Long accountNumber;

    @Schema(
            description = "Type of the account",
            example = "Savings"
    )
    @NotEmpty(message = "Account Type cannot be empty")
    private String accountType;

    @Schema(
            description = "Branch address of the account",
            example = "123 Main St, City, Country"
    )
    @NotEmpty(message = "Branch Address cannot be empty")
    private String branchAddress;
}
