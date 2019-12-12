package controller;

import util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class text {
    String sql = "SELECT*FROM user";
    Connection conn;

    {
        try {
            conn = DataSourceUtils.getConnection();
            System.out.println("connect1");
            PreparedStatement st =conn.prepareStatement(sql);
            System.out.println("connect2");
            ResultSet rs=st.executeQuery();
            System.out.println("connect3");
                while (rs.next()) {
                    System.out.println("connect4");
                }

        } catch (SQLException e) {
            System.out.println("connect5");
            e.printStackTrace();
        }
    }



}
