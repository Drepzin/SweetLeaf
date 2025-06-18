package org.example.models.DAO;

import org.example.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void addUser(User user) throws SQLException;

    User findUser(String username);

    void updateUserPassword(String username, String password);

    void deleteUser(String username);

    String selectField(String fieldName, String user) throws SQLException;
}
