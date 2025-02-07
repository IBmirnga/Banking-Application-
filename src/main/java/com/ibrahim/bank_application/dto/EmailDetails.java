package com.ibrahim.bank_application.dto;


import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {

    private String recipient;
    private String messageBody;
    private String subject;
    private String attachment;


}
