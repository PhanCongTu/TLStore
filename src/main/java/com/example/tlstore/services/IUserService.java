package com.example.tlstore.services;

import com.example.tlstore.dtos.Login;
import com.example.tlstore.dtos.UserDto;
import com.example.tlstore.dtos.UserPagination;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<UserDto> getAllUsers();

    UserPagination getAllPagingUsers(int pageNo, int pageSize, String sortBy, String sortDir);

    UserDto getUserById(Long UserId);

    UserDto getUserByUsername(String username);

    UserDto createUser(UserDto userDto);

    // Cập nhật lại User (chỉ cập nhật những thuộc tính muốn thay đổi)
    UserDto patchUser(Long id, Map<Object, Object> UserDto);

    // Cập nhật lại User (cập nhật lại toàn bộ các thuộc tính)
    UserDto updateUser(Long id, UserDto UserDto) throws NoSuchFieldException, IllegalAccessException;

    // Hàm deleteUser chỉ delete bằng cách set thuộc tính IsDeleted = true chứ không xoá hẳn trong database
    void deleteUser(Long UserId);

    UserDto getUserByUserNameAndPassword(String userName, String password);
}
