package com.datn.service;

import java.util.Optional;

import com.datn.model.Role;
import com.datn.model.RoleName;

public interface RoleService {
    Optional<Role> findByName(RoleName name);
}
