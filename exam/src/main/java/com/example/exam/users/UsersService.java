package com.example.exam.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public Optional<Users> getById(Long usersId) {

        return usersRepository.findById(usersId);
    }

    public List<Users> getAllUsers() {

        return usersRepository.findAll();
    }

    public UsersDto addUsers(UsersDto usersDto) {
        Users users = UsersMapper.toUsers(usersDto);
        Users savedUsers = usersRepository.save(users);
        return UsersMapper.toUsersDto(savedUsers);
    }

    public void deleteUsers(Long id) {
        usersRepository.deleteById(id);
    }
}
