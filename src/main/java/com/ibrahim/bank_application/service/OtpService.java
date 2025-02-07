package com.ibrahim.bank_application.service;

import com.ibrahim.bank_application.dto.*;
import com.ibrahim.bank_application.entity.Otp;
import com.ibrahim.bank_application.repository.OtpRepository;
import com.ibrahim.bank_application.utils.AccountUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class OtpService {

    private final OtpRepository otpRepository;
    private final EmailService emailService;

    public Response sendOtp(OtpRequest otpRequest)  {

        //generate the otp
        //send otp
        //save otp


        //check if he has an opt on our system
        Otp exitingOtp = otpRepository.findByEmail(otpRequest.getEmail());
        if (exitingOtp != null) {
            otpRepository.delete(exitingOtp);
        }

        String otp = AccountUtils.generateOtp();
        log.info("Otp: {}", otp);
        emailService.sendEmail(EmailDetails.builder()
                        .subject("DO NOT DISCLOSE!!!")
                        .recipient(otpRequest.getEmail())
                        .messageBody("This organization has sent you an otp. This otp expires in 2 minutes. " + otp)
                .build());

        otpRepository.save(Otp.builder()
                .email(otpRequest.getEmail())
                .otp(otp)
                .expiresAt(LocalDateTime.now().plusMinutes(2))
                .build());

        return Response.builder()
                .statusCode(200)
                .responseMessage("SUCCESS!")
                .build();
    }

    //ascertain that the user actually sent an otp
    //ascertain the otp hasn't expired
    //ascertain the otp is correct

    public Response validateOtp(OtpValidationRequest otpValidationRequest) {
        Otp otp = otpRepository.findByEmail(otpValidationRequest.getEmail());
        log.info("Email: {}", otpValidationRequest.getEmail());
        if (otp == null) {
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("You have not sent an otp")
                    .build();
        }
        if (otp.getExpiresAt().isBefore(LocalDateTime.now())) {
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("Expired otp")
                    .build();
        }
        if (!otp.getOtp().equals(otpValidationRequest.getOtp())) {
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("Invalid otp")
                    .build();
        }

        return Response.builder()
                .statusCode(200)
                .responseMessage("SUCCESS")
                .otpResponse(OtpResponse.builder()
                        .isOtpValid(true)
                        .build())
                .build();
    }

}
