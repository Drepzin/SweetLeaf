package org.example.models.DAO;

import org.example.models.UserTask;

import java.util.List;

public interface UserTaskDAO {

    void addUserTask(UserTask userTask);

    UserTask findUserTask(String name);

    List<UserTask> findAll(String username);

    void updateUserTask();

    void deleteUserTask(String taskName, String username);
}
