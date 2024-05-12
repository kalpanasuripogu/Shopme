package com.shopme.admin.security;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shopme.common.entity.Role;

@Component
public class RoleFormatter {

    public String formatRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .map(roleName -> roleName.replace("ROLE_", ""))
                .map(StringUtils::capitalize)
                .reduce((role1, role2) -> role1 + ", " + role2)
                .orElse("No roles");
    }
}