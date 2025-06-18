package org.example.persistence;

import org.example.models.DAO.UserTaskDAO;
import org.example.models.UserTask;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserTaskDAOImpl implements UserTaskDAO {

    private Connection conn;

    public UserTaskDAOImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public void addUserTask(UserTask userTask){
        String taskName = userTask.getTaskName();
        Date initDate = (Date) userTask.getTaskDate();
        String description = userTask.getDescription();
        String userUsername = userTask.getUserUsername();
        boolean status = userTask.isComplete();
        //
        String sql = "INSERT INTO user_tasks(task_name, init_date, description, user_owner, status)" +
                " VALUES (?, ?, ?, ?, ?)";
        try{
            conn.setAutoCommit(false);
            try(PreparedStatement pstm = conn.prepareStatement(sql)){
                pstm.setString(1, taskName);
                pstm.setDate(2, initDate);
                pstm.setString(3, description);
                pstm.setString(4, userUsername);
                pstm.setBoolean(5, status);
                pstm.executeUpdate();
                conn.commit();
                System.out.println("task adicionada");
            }
            catch (SQLException e){
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserTask findUserTask(String name) {
        return null;
    }

    @Override
    public List<UserTask> findAll(String username) {
        List<UserTask> tasks = new ArrayList<>();
        String sql = "SELECT * FROM user_tasks u WHERE u.user_owner = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String user = rs.getString(2);
                Date date = rs.getDate(3);
                String description = rs.getString(4);
                boolean status = rs.getBoolean(6);
                UserTask userTask = new UserTask(user, date, description, status);
                tasks.add(userTask);
            }
            return tasks;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserTask() {

    }

    @Override
    public void deleteUserTask(String taskname, String username) {
        String sql = "delete from user_tasks u where u.task_name = ? AND u.user_owner = ?";
        try (PreparedStatement psmt = conn.prepareStatement(sql)){
            conn.setAutoCommit(false);
            psmt.setString(1, taskname);
            psmt.setString(2, username);
            psmt.executeUpdate();
            conn.commit();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
