package com.example.JSP_FILES_LERNING.controller;

import com.example.JSP_FILES_LERNING.model.User;
import com.example.JSP_FILES_LERNING.service.UserService;
import com.example.util.PropsReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final Properties props = PropsReader.loadProperties("messages.properties");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.login(login, password);

        RequestDispatcher requestDispatcher;

        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("/LoginPage.jsp");
            request.setAttribute("message", props.getProperty("message.loginFailed"));
            request.setAttribute("color", "red");
        } else {
            requestDispatcher = request.getRequestDispatcher("/MainPage.jsp");
            request.setAttribute("user", user);
            response.setHeader("Location", "http://localhost:8080/main-page");
        }

        requestDispatcher.forward(request, response);
    }
}
