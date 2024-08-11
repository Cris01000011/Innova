package com.example.demo.manage;

import com.example.demo.User;
import com.example.demo.dto.user;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class Tests {
    @InjectMocks
    private UserManage userManage;

    @Mock
    private UserData userData;

    @Test
    public void searchOne() {
        userManage.getAllElements();
        verify(userData, times(1)).findAll();
    }

    @Test
    public void searchBy() {
        when(userData.findAll()).thenReturn(List.of());
        List<user> users = this.userManage.getAllElements();
        assertNotNull(users);
    }

    @Test
    public void searchAll() {
        User user1 = new User("1", "name", "123", null);

        when(userData.findAll()).thenReturn(List.of(user1));
        List<user> users = this.userManage.getAllElements();
        assertEquals(1, users.size());
    }

    @Test
    public void searchProcess() {
        User user = new User("1", "name", "123", null);

        when(userData.findById("1")).thenReturn(Optional.of(user));

        com.example.demo.dto.user userDto = userManage.getById("1");

        assertNotNull(userDto);
        assertEquals("1", userDto.getId());
        assertEquals("name", userDto.getUser());
    }

    @Test
    public void searchInvalid() {
        when(userData.findById("1")).thenReturn(Optional.empty());

        user user = userManage.getById("1");

        assertNull(user);
    }

    @Test
    public void searchException() {
        User user = new User("1", "name", "123", null);

        when(userData.findById("1")).thenReturn(Optional.of(user));

        com.example.demo.dto.user userDto = userManage.getById("1");

        assertNotNull(userDto);
    }

    @Test
    public void searchValid() {
        when(userData.findById("1")).thenReturn(Optional.empty());

        user user = userManage.getById("1");

        assertNull(user);
    }


    @Test
    public void searchByID() {
        userManage.getById("1");
        verify(userData, times(1)).findById("1");
    }

    @Test
    public void search() {
        when(userData.findAll()).thenReturn(List.of());

        List<user> users = this.userManage.getAllElements();

        assertNotNull(users);
        assertTrue(users.isEmpty());
    }

    @Test
    public void insert() {
        user userDto = new user("1", "name", "123", null);
        User user = new User("1", "name", "123", null);

        when(userData.save(any(User.class))).thenReturn(user);

        com.example.demo.dto.user savedUser = userManage.insert(userDto);

        assertNotNull(savedUser);
        assertEquals("1", savedUser.getId());
        assertEquals("name", savedUser.getUser());
    }

    @Test
    public void insertUser() {
        user userDto = new user("1", "name", "123", null);
        User user = new User("1", "name", "123", null);

        when(userData.save(any(User.class))).thenReturn(user);

        userManage.insert(userDto);

        verify(userData, times(1)).save(any(User.class));
    }

    @Test
    public void insertValid() {
        user userDto = new user("1", "name", "123", null);
        User user = new User("2", "name", "123", null);

        when(userData.save(any(User.class))).thenReturn(user);

        com.example.demo.dto.user savedUser = userManage.insert(userDto);

        assertNotNull(savedUser.getId());
    }

    @Test
    public void updateInvalid() {
        user user = new user(null, "name", "123", null);

        when(userData.findById("1")).thenReturn(Optional.empty());

        user updatedUser = userManage.update(user, "1");

        assertNull(updatedUser);
    }

    @Test
    public void updateById() {
        user user = new user("1", "name", "123", null);
        userManage.update(user, "1");
        verify(userData, times(1)).findById("1");
    }

    @Test
    public void updateData() {
        User user = new User("1", "name", "123", null);
        com.example.demo.dto.user userDto = new user("2", "name", "123", null);

        when(userData.findById("1")).thenReturn(Optional.of(user));
        when(userData.save(any(User.class))).thenReturn(user);

        userManage.update(userDto, "1");

        verify(userData, times(1)).save(any(User.class));
    }

    @Test
    public void deleteProcess() {
        doNothing().when(userData).deleteById("1");

        userManage.delete("1");

        verify(userData, times(1)).deleteById("1");
    }

    @Test
    public void deleteNoFound() {
        doNothing().when(userData).deleteById("1");

        assertDoesNotThrow(() -> userManage.delete("1"));
    }

    @Test
    public void deleteOne() {
        doNothing().when(userData).deleteById("1");

        userManage.delete("1");

        verify(userData, times(1)).deleteById("1");
    }

    @Test
    public void deleteById() {
        doNothing().when(userData).deleteById("1");

        userManage.delete("1");

        verify(userData).deleteById(argThat(id -> id.equals("1")));
    }
}