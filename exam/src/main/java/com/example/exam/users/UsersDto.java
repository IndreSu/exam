package com.example.exam.users;

import com.example.exam.security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private String username;

    @Enumerated(EnumType.STRING)
    private ApplicationUserRole role;

}
