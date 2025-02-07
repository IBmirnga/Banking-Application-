package com.ibrahim.bank_application.repository;

import com.ibrahim.bank_application.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    Otp findByEmail(String email);
}
