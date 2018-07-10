package com.mentorme.mentor.security;

public class SecurityConstants {

    public static final String SECRET = "SecretKeyToGenToken";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL ="/users/sign-up";
    public static final String ROLE_TOKEN_FIELD = "role";
    public static final String ROLE_PREFIX = "ROLE_";
}
