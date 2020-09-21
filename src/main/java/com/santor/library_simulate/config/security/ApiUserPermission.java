package com.santor.library_simulate.config.security;

public enum ApiUserPermission {

    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),

    AUTHOR_READ("author:read"),
    AUTHOR_WRITE("author:write"),

    BOOK_READ("book:read"),
    BOOK_WRITE("book:write"),

    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),

    RENT_READ("rent:read"),
    RENT_WRITE("rent:write");

    private final String permission;

    ApiUserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
