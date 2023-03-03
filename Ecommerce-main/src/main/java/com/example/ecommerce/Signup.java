package com.example.ecommerce;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.ecommerce.Login.getEncryptedPassword;

public class Signup {
    String name;
    String pass;
    String email;
    String mobile;
    String address;

    public static void customerSignup(String userName, String userMobile, String userEmail, String userPass, String userAddress) throws NoSuchAlgorithmException {
        String encryptedPassword = getEncryptedPassword(userPass);
        String query = "insert into customers(name, email, mobile, password, address)values('"+userName+"','"+userEmail+"','"+userMobile+"','"+encryptedPassword+"', '" + userAddress+"')";
        DatabaseConnection dbConn = new DatabaseConnection();
        dbConn.insertUpdate(query);
    }
}