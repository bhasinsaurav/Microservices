package com.eazybytes.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema representing an error response with details"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path where the error occurred",
            example = "/api/v1/accounts/1234567890"
    )
    private String apiPath;

    @Schema(
            description = "HTTP status code representing the error",
            example = "404 NOT_FOUND"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Detailed error message",
            example = "Account not found for the given account number"
    )
    private String errorMessage;

    @Schema(
            description = "Timestamp when the error occurred",
            example = "2024-06-15T14:30:00"
    )
    private LocalDateTime errorTime;
}
