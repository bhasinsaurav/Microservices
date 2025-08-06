package com.eazybytes.accounts.controller;


import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD rest APIs for Accounts",
        description = "CRUD rest APIs for EazyBank Accounts Microservice"
)
@RestController
@RequestMapping(path= "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    private IAccountsService accountsService;

    @Operation(
            summary = "Create Account Rest API",
            description = "REST API to create a new customer and account for a customer"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created - Account created successfully"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);
        return new ResponseEntity<>(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201), HttpStatus.CREATED);

    }

    @Operation(
            summary = "Fetch Account Rest API",
            description = "REST API to fetch a customer and an account for a customer"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Ok - Account fetched successfully"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> getAccounts(@RequestParam
                                                       @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                                       String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchAccounts(mobileNumber);
        return ResponseEntity.ok(customerDto);
    }

    @Operation(
            summary = "Update Account Rest API",
            description = "REST API to update an for a customer"
    )

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status 200 Ok - Account updated successfully"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status 417 Expectation Failed - Unable to update account",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        if(isUpdated) {
            return ResponseEntity.ok(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }
        else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Account Rest API",
            description = "REST API to delete an account for a customer"
    )

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status 200 Ok - Account deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status 417 Expectation Failed - Unable to delete account",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam
                                                         @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                                         String mobileNumber) {
        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        if(isDeleted) {
            return ResponseEntity.ok(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }
        else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
        }
    }


}
