package main.java.by.bsuir.pms413802.Chayevskiy.services;

import main.java.by.bsuir.pms413802.Chayevskiy.DAO.TariffDAO;
import main.java.by.bsuir.pms413802.Chayevskiy.entities.Tariff;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TariffService {

    private static TariffDAO tariffDAO;

    public static void init() {
        tariffDAO = new TariffDAO();
    }

    public static void listTariff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Tariff> listTariff = tariffDAO.listAllTariff();
        request.setAttribute("listTariff", listTariff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("TariffList.jsp");
        dispatcher.forward(request, response);
    }

    public static void updateTariff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Tariff tariff = new Tariff(id, name);
        tariffDAO.updateTariff(tariff);
        response.sendRedirect("list");
    }

    public static void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Tariff existingTariff = tariffDAO.getTariff(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("TariffForm.jsp");
        request.setAttribute("tariff", existingTariff);
        dispatcher.forward(request, response);
    }


    public static void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("TariffForm.jsp");
        dispatcher.forward(request, response);
    }

    public static void insertTariff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");

        Tariff newTariff = new Tariff(name);
        tariffDAO.insertTariff(newTariff);
        response.sendRedirect("list");
    }

    public static void deleteTariff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Tariff tariff = new Tariff(id);
        tariffDAO.deleteTariff(tariff);
        response.sendRedirect("list");
    }
}
