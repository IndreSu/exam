package com.example.exam.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {
    CLIENT(Sets.newHashSet(ApplicationUserPermission.CLIENT_READ, ApplicationUserPermission.CLIENT_WRITE)),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.ADMIN_READ, ApplicationUserPermission.ADMIN_WRITE, ApplicationUserPermission.CLIENT_READ, ApplicationUserPermission.CLIENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {

        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {

        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
