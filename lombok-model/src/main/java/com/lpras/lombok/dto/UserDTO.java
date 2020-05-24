package com.lpras.lombok.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String mobile;
    private String status;
    private Set<RoleDTO> roles;
}
