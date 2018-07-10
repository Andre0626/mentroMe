package com.mentorme.mentor.service.role.mapper;

import com.mentorme.mentor.dto.Role.NewRole;
import com.mentorme.mentor.dto.Role.RoleDto;
import com.mentorme.mentor.entity.Role;


public class RoleMapper {

    public static Role mapEntity(NewRole newRole) {
        Role role = new Role();

        role.setUserRole(newRole.getRoleName());

        return role;
    }

    public static RoleDto mapDto(Role role) {
        RoleDto roleDto = new RoleDto();

        role.setId(role.getId());
        role.setUserRole(role.getUserRole());

        return roleDto;
    }
}
