package com.notify.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.notify.model.LoginBean;
import com.notify.model.User;
import com.notify.utils.JDBCUtils;
public class LoginDao {
    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
         System.out.println("ha");
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from user where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getEmail());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return status;
    }
    public int getId_(LoginBean loginBean) throws ClassNotFoundException {
        int id_=0;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = JDBCUtils.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getEmail());
            preparedStatement.setString(2, loginBean.getPassword());
         
ResultSet rs = preparedStatement.executeQuery();
           
           if (rs.next()) {
				 id_ =  rs.getInt(1);
			}

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return id_;
    }
    
    
    public int getNoteBookId_(int id) throws ClassNotFoundException {
        int id_=0;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = JDBCUtils.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement("select * from noteBook where user_id =? ")) {
            preparedStatement.setInt(1, id);
           
         
ResultSet rs = preparedStatement.executeQuery();
           
           if (rs.next()) {
				 id_ =  rs.getInt(1);
			}

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return id_;
    }
    
    
    
    
    public String getuser_(LoginBean loginBean) throws ClassNotFoundException {
        String user_="";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = JDBCUtils.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getEmail());
            preparedStatement.setString(2, loginBean.getPassword());
         
ResultSet rs = preparedStatement.executeQuery();
           
           if (rs.next()) {
				 user_ =  rs.getString(5);
			}

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return user_;
        
    }




}
