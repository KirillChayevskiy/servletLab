package main.java.by.bsuir.pms413802.Chayevskiy.controller;

import main.java.by.bsuir.pms413802.Chayevskiy.DAO.UserDAO;
import main.java.by.bsuir.pms413802.Chayevskiy.entities.User;
import main.java.by.bsuir.pms413802.Chayevskiy.services.RelationService;
import main.java.by.bsuir.pms413802.Chayevskiy.services.TariffService;
import main.java.by.bsuir.pms413802.Chayevskiy.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        UserService.init();
        TariffService.init();
        RelationService.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newUser":
                    UserService.showNewForm(request, response);
                    break;
                case "/insertUser":
                    UserService.insertUser(request, response);
                    break;
                case "/deleteUser":
                    UserService.deleteUser(request, response);
                    break;
                case "/editUser":
                    UserService.showEditForm(request, response);
                    break;
                case "/updateUser":
                    UserService.updateUser(request, response);
                    break;
                case "/newTariff":
                    TariffService.showNewForm(request, response);
                    break;
                case "/insertTariff":
                    TariffService.insertTariff(request, response);
                    break;
                case "/deleteTariff":
                    TariffService.deleteTariff(request, response);
                    break;
                case "/editTariff":
                    TariffService.showEditForm(request, response);
                    break;
                case "/updateTariff":
                    TariffService.updateTariff(request, response);
                    break;
                case "/listTariff":
                    TariffService.listTariff(request, response);
                    break;
                case "/newRelation":
                    RelationService.showNewForm(request, response);
                    break;
                case "/insertRelation":
                    RelationService.insertRelation(request, response);
                    break;
                case "/deleteRelation":
                    RelationService.deleteRelation(request, response);
                    break;
                case "/editRelation":
                    RelationService.showEditForm(request, response);
                    break;
                case "/updateRelation":
                    RelationService.updateRelation(request, response);
                    break;
                case "/listRelation":
                    RelationService.listRelation(request, response);
                    break;
                default:
                    UserService.listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }



}
