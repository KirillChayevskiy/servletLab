package main.java.by.bsuir.pms413802.Chayevskiy.services;

import main.java.by.bsuir.pms413802.Chayevskiy.DAO.RelationDAO;
import main.java.by.bsuir.pms413802.Chayevskiy.entities.Relation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RelationService {

    private static RelationDAO relationDAO;

    public static void init() {
        relationDAO = new RelationDAO();
    }

    public static void listRelation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Relation> listRelation = relationDAO.listAllRelation();
        request.setAttribute("listRelation", listRelation);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserTariffList.jsp");
        dispatcher.forward(request, response);
    }

    public static void updateRelation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int userID = Integer.parseInt(request.getParameter("userID"));
        int tariffID = Integer.parseInt(request.getParameter("tariffID"));

        Relation relation = new Relation(id, userID, tariffID);
        relationDAO.updateRelation(relation);
        response.sendRedirect("list");
    }

    public static void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Relation existingRelation = relationDAO.getRelation(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserTariffForm.jsp");
        request.setAttribute("relation", existingRelation);
        dispatcher.forward(request, response);
    }


    public static void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserTariffForm.jsp");
        dispatcher.forward(request, response);
    }

    public static void insertRelation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        int tariffID = Integer.parseInt(request.getParameter("tariffID"));

        Relation newRelation = new Relation(userID, tariffID);
        relationDAO.insertRelation(newRelation);
        response.sendRedirect("list");
    }

    public static void deleteRelation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Relation relation = new Relation(id);
        relationDAO.deleteRelation(relation);
        response.sendRedirect("list");
    }
}
