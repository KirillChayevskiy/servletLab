package main.java.by.bsuir.pms413802.Chayevskiy.services;

import main.java.by.bsuir.pms413802.Chayevskiy.DAO.UserDAO;
import main.java.by.bsuir.pms413802.Chayevskiy.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private static UserDAO userDAO;

    public static void init() {
        userDAO = new UserDAO();
    }

    public static void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.listAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
        dispatcher.forward(request, response);
    }

    public static void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        User user = new User(id, name, surname);
        userDAO.updateUser(user);
        response.sendRedirect("list");
    }

    public static void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }


    public static void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
        dispatcher.forward(request, response);
    }

    public static void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        User newUser = new User(name, surname);
        userDAO.insertUser(newUser);
        response.sendRedirect("list");
    }

    public static void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        User user = new User(id);
        userDAO.deleteUser(user);
        response.sendRedirect("list");
    }
}
