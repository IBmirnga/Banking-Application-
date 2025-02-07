package com.ibrahim.bank_application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankResponse {

    private String responseCode;
    private String responseMessage;
    private AccountInfo accountInfo;

}

