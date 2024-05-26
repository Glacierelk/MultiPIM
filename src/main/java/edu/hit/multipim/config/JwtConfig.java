package edu.hit.multipim.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class JwtConfig {
    private static JwtConfig instance;

    @Value("${jwt.sign-key}")
    private String JWT_SIGN_KEY;
}

