package controller;

import model.model.employee.Employee;
import model.service.IEmployeeService;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static IEmployeeService iEmployeeService = new EmployeeServiceImpl();

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
                getEdit(request, response);
                break;

        }
    }

    private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeName = request.getParameter("employeeName");
        String employeebirthday = request.getParameter("employeebirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String userName = request.getParameter("userName");
        Employee employee = new Employee(employeeName, employeebirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail,
                employeeAddress, positionId, educationDegreeId, divisionId, userName);
        iEmployeeService.create(employee);
        response.sendRedirect("/employee");
    }

    private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idEdit"));
        String employeeName = request.getParameter("employeeName");
        String employeebirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String userName = request.getParameter("userName");
        Employee employee = new Employee(id, employeeName, employeebirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail,
                employeeAddress, positionId, educationDegreeId, divisionId, userName);
        iEmployeeService.Edit(employee);
        response.sendRedirect("/employee");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "search":
                showSearch(request, response);
                break;
            default:
                request.setAttribute("listEmployee", iEmployeeService.getAll());
                request.getRequestDispatcher("employee/list.jsp").forward(request, response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPosition", iEmployeeService.getAllPosition());
        request.setAttribute("listED", iEmployeeService.getAllEducationDegree());
        request.setAttribute("listDivision", iEmployeeService.getAllDivision());
        request.setAttribute("listUser", iEmployeeService.getAllUser());
        request.getRequestDispatcher("employee/create.jsp").forward(request, response);

    }



    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idEdit"));
        Employee employee = iEmployeeService.getEmployeeEdit(id);
        request.setAttribute("employeeName", employee.getEmployeeName());
        request.setAttribute("employeeBirthday", employee.getEmployeeBirthday());
        request.setAttribute("employeeIdCard", employee.getEmployeeId());
        request.setAttribute("employeeSalary", employee.getEmployeeSalary());
        request.setAttribute("employeePhone", employee.getEmployeePhone());
        request.setAttribute("employeeEmail", employee.getEmployeeEmail());
        request.setAttribute("employeeAddress", employee.getEmployeeAddress());
        request.setAttribute("positionId1", employee.getPositionId());
        request.setAttribute("educationDegreeId1", employee.getEducationDegreeId());
        request.setAttribute("divisionId1", employee.getDivisionId());
        request.setAttribute("status", employee.getStatus());
        request.setAttribute("listPosition", iEmployeeService.getAllPosition());
        request.setAttribute("listED", iEmployeeService.getAllEducationDegree());
        request.setAttribute("listDivision", iEmployeeService.getAllDivision());
        request.setAttribute("listUser", iEmployeeService.getAllUser());
        request.getRequestDispatcher("employee/edit.jsp").forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        iEmployeeService.detele(idDelete);
        response.sendRedirect("/employee");
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String searchName = request.getParameter("search");
        request.setAttribute("txtSearch",searchName);
        request.setAttribute("listEmployee",iEmployeeService.sreachEmployeeName(searchName));
        request.getRequestDispatcher("/employee/list.jsp").forward(request,response);
    }
}
