package com.MyCricket.MyCricket.Entity;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class Auth {
    private String userId;
    private String accessToken;
    private String refreshToken;

    private long expireAt;

    private Collection<String> authorities;
}