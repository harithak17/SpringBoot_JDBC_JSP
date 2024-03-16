package org.servlets.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.servlets.Model.User;

public class UserDao {

	
	
	private static final String ADD_USER_QUERY = "INSERT INTO users (name, email, phone, dob, subscribed, gender, country) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET name = ?, email = ?, phone = ?, dob = ?, subscribed = ?, gender = ?, country = ? WHERE id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM users";

	 // Add a new user
    public static void addUser(User user) {
        // Implement database insertion logic here
    	
    	try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_QUERY)) {

               preparedStatement.setString(1, user.getName());
               preparedStatement.setString(2, user.getEmail());
               preparedStatement.setString(3, user.getPhone());
               preparedStatement.setString(4, user.getDob());
               preparedStatement.setBoolean(5, user.isSubscribed());
               preparedStatement.setString(6, user.getGender());
               preparedStatement.setString(7, user.getCountry());

               preparedStatement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();  // Handle the exception appropriately in a real application
           }
    }

    // Get a user by ID
    public static User getUserById(int id) {
        // Implement database retrieval logic here
    	try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID_QUERY)) {
    		preparedStatement.setInt(1, id);
    		try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractUserFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle the exception appropriately in a real application
        }
        return null;
    }

    // Update user details
    public static void updateUser(User user) {
    	  try (Connection connection = DBConnection.getConnection();
    	             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY)) {

    	            preparedStatement.setString(1, user.getName());
    	            preparedStatement.setString(2, user.getEmail());
    	            preparedStatement.setString(3, user.getPhone());
    	            preparedStatement.setString(4, user.getDob());
    	            preparedStatement.setBoolean(5, user.isSubscribed());
    	            preparedStatement.setString(6, user.getGender());
    	            preparedStatement.setString(7, user.getCountry());
    	            preparedStatement.setInt(8, user.getId());

    	            preparedStatement.executeUpdate();
    	        } catch (SQLException e) {
    	            e.printStackTrace();  // Handle the exception appropriately in a real application
    	        }
    }

    // Delete a user by ID
    public static void deleteUser(int id) {
    	 try (Connection connection = DBConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY)) {

                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();  // Handle the exception appropriately in a real application
            }
    }

    // Get all users
    public static List<User> getAllUsers() {
        // Implement database retrieval logic here
    	List<User> users = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = extractUserFromResultSet(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle the exception appropriately in a real application
        }

        return users;
    }
    private static User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        user.setDob(resultSet.getString("dob"));
        user.setSubscribed(resultSet.getBoolean("subscribed"));
        user.setGender(resultSet.getString("gender"));
        user.setCountry(resultSet.getString("country"));
        return user;
    }
}
