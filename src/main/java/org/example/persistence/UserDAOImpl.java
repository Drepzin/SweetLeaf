package org.example.persistence;

import org.example.connection.DB;
import org.example.models.DAO.UserDAO;
import org.example.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private Connection conn;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addUser(User user) throws SQLException {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO user_table (full_name, username, email, password)"
                    + " VALUES (?, ?, ?, ?)");
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getUserName());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            pst.executeUpdate();
            System.out.println("User created");
    }

    @Override
    public User findUser(String username) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM user_table u WHERE u.username = ?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                User user = new User(rs.getString("full_name"), rs.getString("username"),
                        rs.getString("email"), rs.getString("password"));
                rs.close();
                pst.close();
               try{
                   conn.close();
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserPassword(String username, String password) {
        String sql = "update user_table u set password = ? where u.username = ?";
        try{
            conn.setAutoCommit(false);
            try(PreparedStatement pstm = conn.prepareStatement(sql)){
                pstm.setString(1, password);
                pstm.setString(2, username);
                pstm.executeUpdate();
                conn.commit();
                System.out.println("Password changed");
                try{
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public String selectField (String fieldName, String username) throws SQLException{
        String sql = "SELECT " + fieldName + " from user_table u WHERE u.username = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }
}
