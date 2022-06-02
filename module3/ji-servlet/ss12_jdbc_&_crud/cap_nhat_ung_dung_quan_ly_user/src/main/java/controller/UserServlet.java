package controller;

import com.sun.javafx.logging.JFRInputEvent;
import model.User;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private static IUserService iUserService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                getCreate(request, response);
                break;
            case "update":
                getEdit(request, response);
                break;
        }

    }

    private void getCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        iUserService.createUser(user);
        response.sendRedirect("/user");

    }

    private void getEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        String nameEdit = request.getParameter("nameEdit");
        String emailEdit = request.getParameter("emailEdit");
        String countryEdit = request.getParameter("countryEdit");
        iUserService.editUser(idEdit, nameEdit, emailEdit, countryEdit);
        response.sendRedirect("/user");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "search":
                searchUser(request, response);
                break;
            default:
                request.setAttribute("listUser", iUserService.getAll());
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        iUserService.delete(id);
        response.sendRedirect("/user");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        for (User u : iUserService.getAll()) {
            if (u.getId() == idEdit) {
                request.setAttribute("id", u.getId());
                request.setAttribute("ten", u.getName());
                request.setAttribute("email", u.getEmail());
                request.setAttribute("country", u.getCountry());
                break;
            }
        }
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String searchCountry = request.getParameter("searchCountry");
        request.setAttribute("txtSearch",searchCountry);
        request.setAttribute("listUser",iUserService.searchConutry(searchCountry));
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
