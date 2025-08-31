package com.study.devstudy.java.totp;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class TotpGenerator {

    private String secretKey; // 비밀 키 (문자열 형태)
    private String hashedKey; // SHA-256 해시값의 앞 20자리
    private String totp;

    public TotpGenerator(String secretKey) {
        this.secretKey = secretKey; // memberNo
        this.hashedKey = hashKey(secretKey);
        this.totp = generateTOTP(secretKey);
    }

    // 비밀 키를 SHA-256으로 해시한 뒤 앞 20자리만 사용
    private String hashKey(String secretKey) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(secretKey.getBytes(StandardCharsets.UTF_8));

            // 해시 값의 앞 20바이트를 16진수 문자열로 변환
            return bytesToHex(hash).substring(0, 20);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing key", e);
        }
    }

    // 바이트 배열을 16진수 문자열로 변환
    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String generateTOTP(String secretKey) {
        try {
            long timeWindow = 60; // TOTP 유효 기간 (초)
            long time = Instant.now().getEpochSecond() / timeWindow; // 현재 시간(초)을 60초로 나눈 값

            byte[] key = secretKey.getBytes(StandardCharsets.UTF_8); // 비밀 키를 바이트 배열로 변환
            ByteBuffer buffer = ByteBuffer.allocate(8);
            buffer.putLong(time);
            byte[] timeBytes = buffer.array();

            Mac mac = Mac.getInstance("HmacSHA1"); // HMAC-SHA1 알고리즘 사용
            SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
            mac.init(signKey);

            byte[] hash = mac.doFinal(timeBytes); // HMAC 계산
            int offset = hash[hash.length - 1] & 0xF; // 해시의 마지막 4비트를 사용하여 오프셋 결정

            int binary = ((hash[offset] & 0x7F) << 24) |
                    ((hash[offset + 1] & 0xFF) << 16) |
                    ((hash[offset + 2] & 0xFF) << 8) |
                    (hash[offset + 3] & 0xFF);

            int otp = binary % 1000000; // 6자리 OTP 생성

            return String.format("%06d", otp); // 6자리의 TOTP 반환
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Error generating TOTP", e);
        }
    }

    @Override
    public String toString() {
        return "TotpGenerator{" +
                "secretKey='" + secretKey + '\'' +
                ", hashedKey='" + hashedKey + '\'' +
                ", totp='" + totp + '\'' +
                '}';
    }
}