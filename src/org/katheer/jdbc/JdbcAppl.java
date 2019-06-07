package org.katheer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcAppl {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost" +
                ":3306/spring", "root", "katheer");

        /*
        //Using statement
        Statement statement = con.createStatement();
        statement.addBatch("INSERT INTO users VALUES (101, 'AAA', 5000, " +
                "'Dindigul')");
        statement.addBatch("INSERT INTO users VALUES (102, 'BBB', 6000, " +
                "'Madurai')");
        statement.addBatch("INSERT INTO users VALUES (103, 'CCC', 6000, " +
                "'Chennai')");
        statement.addBatch("INSERT INTO users VALUES (104, 'DDD', 7000, " +
                "'Trichy')");
        statement.addBatch("DELETE FROM users WHERE id=101");
        statement.addBatch("UPDATE users SET salary = salary + 550 WHERE " +
                "salary < 10000");
        int[] results = statement.executeBatch();

        for (int result : results) {
            System.out.println("Rows Affected : " + result);
        }

        statement.close();
        */

        //Using Prepared Statement
        PreparedStatement preparedStatement = con.prepareStatement("INSERT " +
                "INTO users VALUES(?,?,?,?)");

        preparedStatement.setInt(1, 105);
        preparedStatement.setString(2, "EEE");
        preparedStatement.setFloat(3, 8000);
        preparedStatement.setString(4, "Salem");
        preparedStatement.addBatch();

        preparedStatement.setInt(1, 106);
        preparedStatement.setString(2, "FFF");
        preparedStatement.setFloat(3, 9000);
        preparedStatement.setString(4, "Vriddhachalam");
        preparedStatement.addBatch();

        preparedStatement.setInt(1, 107);
        preparedStatement.setString(2, "GGG");
        preparedStatement.setFloat(3, 10000);
        preparedStatement.setString(4, "Erode");
        preparedStatement.addBatch();

        int [] results = preparedStatement.executeBatch();

        for (int result : results) {
            System.out.println("Rows Affected : " + result);
        }

    }
}
