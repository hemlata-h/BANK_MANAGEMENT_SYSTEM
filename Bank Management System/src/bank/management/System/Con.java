package bank.management.System;

import java.sql.*;

public class Con {
    Connection connection;
    Statement statement;

    public Con() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "Hemlata", "Hemlata@123");
            statement = connection.createStatement();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}

