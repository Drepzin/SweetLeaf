package org.example.models.DAO;

import org.example.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void addUser(User user) throws SQLException;

    User findUser(String username);

    void updateUser(User user);

    void deleteUser(String username);

    String selectField(String fieldName, String user) throws SQLException;
}
