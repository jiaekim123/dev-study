package com.study.devstudy.java.totp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TotpGeneratorTest {

    @Test
    void generateTOTP() {
        String memberNo = "10523873";
        TotpGenerator totpGenerator = new TotpGenerator(memberNo);
        String totp = totpGenerator.generateTOTP(memberNo);
        Assertions.assertEquals(6, totp.length());
        System.out.println("TOTP Result: " + totp);
        System.out.println("TOTP Generator Info: " + totpGenerator);
    }
}
