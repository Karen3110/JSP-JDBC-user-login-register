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

@WebServlet(name = "RegisterServlet", value = "/register-user")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final Properties props = PropsReader.loadProperties("messages.properties");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        User user = new User(0, name, surname, login, password, address, contact);

        boolean isRegistered = userService.signUp(user);

        RequestDispatcher requestDispatcher;
        if (isRegistered) {
            request.setAttribute("message", props.getProperty("message.registrationSuccess"));
            request.setAttribute("color", "green");
            requestDispatcher= request.getRequestDispatcher("/");
        } else {
            request.setAttribute("message", props.getProperty("message.registrationFailed"));
            request.setAttribute("color", "red");
            requestDispatcher = request.getRequestDispatcher("/register");
        }
        requestDispatcher.forward(request, response);
    }
}
