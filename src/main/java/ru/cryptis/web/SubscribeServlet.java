package ru.cryptis.web;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by pashik on 24.08.2014 15:01.
 */
public class SubscribeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter output = new PrintWriter(resp.getOutputStream());
        try {
            DataSource dataSource = (DataSource) new InitialContext().lookup("java:/cryptisds");
            Connection connection = dataSource.getConnection();

            String email = req.getParameter("email");
            PreparedStatement statement = connection.prepareStatement("insert into subscriptions (email) values (?)");
            statement.setString(1, email);
            statement.executeUpdate();
            output.println("{\"success\":true}");
        } catch (Exception e) {
            output.println("{\"success\":false}");
        } finally {
            output.close();
        }
    }
}
