package com.example.exam.users;

public class UsersMapper {

    public static Users toUsers(UsersDto userDto) {

        Users users = new Users();
        users.setUsername(userDto.getUsername());
        users.setRole(userDto.getRole());

        return users;
    }

    public static UsersDto toUsersDto(Users users){

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername(users.getUsername());
        usersDto.setRole(users.getRole());

        return usersDto;
    }
}
