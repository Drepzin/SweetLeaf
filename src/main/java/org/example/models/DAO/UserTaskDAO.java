package org.example.models.DAO;

import org.example.models.UserTask;

import java.util.List;

public interface UserTaskDAO {

    void addUserTask();

    UserTask findUserTask(String name);

    List<UserTask> findAll();

    void updateUserTask();

    void deleteUserTask();
}
