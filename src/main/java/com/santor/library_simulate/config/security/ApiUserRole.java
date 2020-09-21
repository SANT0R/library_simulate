package com.santor.library_simulate.config.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.santor.library_simulate.config.security.ApiUserPermission.*;

public enum ApiUserRole {

    CLIENT(Sets.newHashSet(AUTHOR_READ,BOOK_READ,
                        CLIENT_READ, CLIENT_WRITE,
                        RENT_READ, RENT_WRITE)),

    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE,
                        AUTHOR_READ,AUTHOR_WRITE,
                        BOOK_READ, BOOK_WRITE,
                        CLIENT_READ, CLIENT_WRITE,
                        RENT_READ, RENT_WRITE));

    private final Set<ApiUserPermission> permission;

    ApiUserRole(Set<ApiUserPermission> permission) {
        this.permission = permission;
    }

    public Set<ApiUserPermission> getPermission() {
        return permission;
    }
}
