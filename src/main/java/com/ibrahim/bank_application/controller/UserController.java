package com.ibrahim.bank_application.controller;

import com.ibrahim.bank_application.dto.*;
import com.ibrahim.bank_application.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User account management APIs")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(
            summary = "Create New User Account",
            description = "Creating a new user and assigning an account ID"
    )
    @ApiResponse(
            responseCode = "201",
            description = "http Status 201 CREATED"
    )
    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }

    @Operation(
            summary = "Logging Into User Account",
            description = "Logging into account with email and password"
    )
    @ApiResponse(
            responseCode = "201",
            description = "http Status 201 LOGGED IN SUCCESSFULLY"
    )
    @PostMapping("login")
    public BankResponse login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }

    @Operation(
            summary = "Balance Enquiry",
            description = "Given an account number, check how much the user has"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http Status 200 SUCCESS"
    )
    @GetMapping("balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request) {
        return userService.balanceEnquiry(request);
    }

    @Operation(
            summary = "Name Enquiry",
            description = "Given an account number, provide the user's name"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http Status 200 SUCCESS"
    )
    @GetMapping("nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request) {
        return userService.nameEnquiry(request);
    }

    @Operation(
            summary = "Credit an Account",
            description = "Given an account number and amount, send said amount to the account"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http Status 200 SUCCESSFULLY CREDITED"
    )
    @PostMapping("credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request) {
        return userService.creditAccount(request);
    }

    @Operation(
            summary = "Debit an Account",
            description = "Given an account number and amount, remove said amount from the account"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http Status 200 SUCCESSFULLY DEBITED"
    )
    @PostMapping("debit")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest request) {
        return userService.debitAccount(request);
    }

    @Operation(
            summary = "Transfer From One Account to Another Account",
            description = "Given a source and destination account number and amount, transfer said amount from source account to the destination account"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http Status 200 TRANSFER SUCCESSFUL"
    )
    @PostMapping("transfer")
    public BankResponse transfer(@RequestBody TransferRequest request) {
        return userService.transfer(request);
    }

}
