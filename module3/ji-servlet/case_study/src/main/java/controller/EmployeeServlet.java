package controller;

import model.model.customer.Customer;
import model.service.ICustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static ICustomerService iCustomerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                getCreate(request, response);
                break;
            case "edit":
                getEdit2(request, response);
                break;

        }
    }

    private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customerTypeId, name, birthday, gender, idCard, phone, email, address);
        iCustomerService.create(customer);
        response.sendRedirect("/employee");
    }

    private void getEdit2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("idEdit"));
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customerId, customerTypeId, name, birthday, gender, idCard, phone, email, address);
        iCustomerService.Edit(customer);
        response.sendRedirect("/employee");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("employee/create.jsp").forward(request, response);
                break;
            case "edit":
                getEdit(request, response);
                break;
            case "delete":
                getDelete(request, response);
                break;
            case "search":
                getSearch(request, response);
                break;
            default:
                request.setAttribute("listEmployee", iCustomerService.getAll());
                request.getRequestDispatcher("employee/list.jsp").forward(request, response);
                break;
        }
    }

    private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        for (Customer c : iCustomerService.getAll()) {
            if (c.getCustomerId() == idEdit) {
                request.setAttribute("customerTypeId", c.getCustomerTypeId());
                request.setAttribute("name", c.getName());
                request.setAttribute("birthday", c.getBirthday());
                request.setAttribute("gender", c.getGender());
                request.setAttribute("idCard", c.getIdCard());
                request.setAttribute("phone", c.getPhone());
                request.setAttribute("email", c.getEmail());
                request.setAttribute("address", c.getAddress());
                break;
            }
        }
        request.getRequestDispatcher("employee/edit.jsp").forward(request, response);
    }

    private void getDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        iCustomerService.detele(idDelete);
        response.sendRedirect("/employee");
    }

    private void getSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String searchName = request.getParameter("search");
        request.setAttribute("txtSearch",searchName);
        request.setAttribute("listEmployee",iCustomerService.sreachCustomerName(searchName));
        request.getRequestDispatcher("employee/list.jsp").forward(request,response);
    }
}
