package com.lms.authservice.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "application.security.jwt")
@Validated
@Getter
@Setter
public class JwtProperties {

    /**
     * Must be a 256-bit (minimum 32-character) secret string provided via environment variables.
     */
    @NotBlank(message = "JWT Secret key cannot be blank")
    @Size(min = 32, message = "JWT Secret must be at least 256 bits (32 characters)")
    private String secretKey;

    /**
     * Token expiration time in milliseconds.
     */
    @Positive(message = "JWT Expiration must be a positive integer")
    private long expiration;
}