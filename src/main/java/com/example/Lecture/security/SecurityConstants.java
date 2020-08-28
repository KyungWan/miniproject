package com.example.Lecture.security;

public final class SecurityConstants {
    public static final String AUTH_LOGIN_URL = "/api/authenticate";
    // http://www.allkeysgenerator.com
    public static final String JWT_SECRET =
            "t7w!z%C*F-JaNdRfUjXn2r5u8x/A?D(G+KbPeShVkYp3s6v9y$B&E)H@McQfTjWn";
    // JWT 기본 토큰
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
}
