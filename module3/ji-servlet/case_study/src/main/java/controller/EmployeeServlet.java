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
import java.util.Map;

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
        double employeeSalary= 0;
        String errEmployeeSalary = null;
        try {
            employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        }catch (NumberFormatException e){
            errEmployeeSalary = "Muốn đi làm ko lương à";
        }

        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");

        Integer positionId = 0;
        String errPositionId = null;
        try {
            positionId = Integer.parseInt(request.getParameter("positionId"));
        }catch (NumberFormatException e){
            errPositionId = "Làm người ai lại đi f12";
        }
        Integer educationDegreeId = 0;
        String errEducationDegreeId = null;
        try {
            educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        }catch (NumberFormatException e){
            errEducationDegreeId = "Làm người ai lại đi f12";
        }
        Integer divisionId = 0;
        String errDivisionId = null;
        try {
            divisionId = Integer.parseInt(request.getParameter("divisionId"));
        }catch (NumberFormatException e){
            errDivisionId = "Làm người ai lại đi f12";
        }

        String userName = request.getParameter("userName");
        Employee employee = new Employee(employeeName, employeebirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail,
                employeeAddress, positionId, educationDegreeId, divisionId, userName);
        Map<String, String> errMap = iEmployeeService.create(employee);
        if(errEmployeeSalary == null){
            errMap.put("errEmployeeSalary",errEmployeeSalary);
        }
        if(errPositionId == null){
            errMap.put("errPositionId",errPositionId);
        }
        if(errEducationDegreeId == null){
            errMap.put("errEducationDegreeId",errEducationDegreeId);
        }
        if(errDivisionId == null){
            errMap.put("errDivisionId",errDivisionId);
        }
        if (errMap.isEmpty()){
            response.sendRedirect("/employee");
        }else {
            request.setAttribute("employeeName", employee.getEmployeeName());
            request.setAttribute("employeeBirthday", employee.getEmployeeBirthday());
            request.setAttribute("employeeIdCard", employee.getEmployeeIdCard());
            request.setAttribute("employeeSalary", employee.getEmployeeSalary());
            request.setAttribute("employeePhone", employee.getEmployeePhone());
            request.setAttribute("employeeEmail", employee.getEmployeeEmail());
            request.setAttribute("employeeAddress", employee.getEmployeeAddress());
            request.setAttribute("positionId", employee.getPositionId());
            request.setAttribute("educationDegreeId", employee.getEducationDegreeId());
            request.setAttribute("divisionId", employee.getDivisionId());
            request.setAttribute("listPosition", iEmployeeService.getAllPosition());
            request.setAttribute("listED", iEmployeeService.getAllEducationDegree());
            request.setAttribute("listDivision", iEmployeeService.getAllDivision());
            request.setAttribute("listUser", iEmployeeService.getAllUser());
            request.setAttribute("errMap", errMap);
            request.getRequestDispatcher("/employee/create.jsp").forward(request,response);
        }
    }

    private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("idEdit"));
        String employeeName = request.getParameter("employeeName");
        String employeebirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");

        double employeeSalary= 0;
        String errEmployeeSalary= null;
        try {
            employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        }catch(NumberFormatException e){
            errEmployeeSalary = "Đù ghê đi làm không lương luôn";
        }


        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        Integer positionId = 0;
        String errPositionId = null;
        try {
            positionId = Integer.parseInt(request.getParameter("positionId"));
        } catch (NumberFormatException e) {
            errPositionId = "Làm người ai lại đi f12";
        }
        Integer educationDegreeId = 0;
        String errEducationDegreeId = null;
        try {
            educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        } catch (NumberFormatException e) {
            errEducationDegreeId = "Làm người ai lại đi f12";
        }
        Integer divisionId =0;
        String errDivisionId = null;
        try {
            divisionId = Integer.parseInt(request.getParameter("divisionId"));
        } catch (NumberFormatException e) {
            errDivisionId = "Làm người ai lại đi f12";
        }
        String userName = request.getParameter("userName");
        Employee employee = new Employee(id, employeeName, employeebirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail,
                employeeAddress, positionId, educationDegreeId, divisionId, userName);
        Map<String, String>  errMap = iEmployeeService.Edit(employee);
        if (errEmployeeSalary != null) {
            errMap.put("errEmployeeSalary", errEmployeeSalary);
        }
        if (errPositionId != null) {
            errMap.put("errPositionId", errPositionId);
        }
        if (errEducationDegreeId != null) {
            errMap.put("errEducationDegreeId", errEducationDegreeId);
        }
        if (errDivisionId != null) {
            errMap.put("errDivisionId", errDivisionId);
        }
        if (errMap.isEmpty()) {

            response.sendRedirect("/employee");
        } else {
            request.setAttribute("employeeName", employee.getEmployeeName());
            request.setAttribute("employeeBirthday", employee.getEmployeeBirthday());
            request.setAttribute("employeeIdCard", employee.getEmployeeIdCard());
            request.setAttribute("employeeSalary", employee.getEmployeeSalary());
            request.setAttribute("employeePhone", employee.getEmployeePhone());
            request.setAttribute("employeeEmail", employee.getEmployeeEmail());
            request.setAttribute("employeeAddress", employee.getEmployeeAddress());
            request.setAttribute("positionId", employee.getPositionId());
            request.setAttribute("educationDegreeId", employee.getEducationDegreeId());
            request.setAttribute("divisionId", employee.getDivisionId());
            request.setAttribute("listPosition", iEmployeeService.getAllPosition());
            request.setAttribute("listED", iEmployeeService.getAllEducationDegree());
            request.setAttribute("listDivision", iEmployeeService.getAllDivision());
            request.setAttribute("listUser", iEmployeeService.getAllUser());
            request.setAttribute("errMap", errMap);
            request.getRequestDispatcher("/employee/edit.jsp").forward(request,response);
        }
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
                showEmployee(request, response);
                break;
        }
    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPosition", iEmployeeService.getAllPosition());
        request.setAttribute("listED", iEmployeeService.getAllEducationDegree());
        request.setAttribute("listDivision", iEmployeeService.getAllDivision());
        request.setAttribute("listEmployee", iEmployeeService.getAll());
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPosition", iEmployeeService.getAllPosition());
        request.setAttribute("listED", iEmployeeService.getAllEducationDegree());
        request.setAttribute("listDivision", iEmployeeService.getAllDivision());
        request.setAttribute("listUser", iEmployeeService.getAllUser());
        request.getRequestDispatcher("/employee/create.jsp").forward(request, response);

    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("idEdit"));
        Employee employee = iEmployeeService.getEmployeeEdit(id);
        request.setAttribute("employeeName", employee.getEmployeeName());
        request.setAttribute("employeeBirthday", employee.getEmployeeBirthday());
        request.setAttribute("employeeIdCard", employee.getEmployeeIdCard());
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
        request.getRequestDispatcher("/employee/edit.jsp").forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idDelete = Integer.parseInt(request.getParameter("idDelete"));
        iEmployeeService.detele(idDelete);
        response.sendRedirect("/employee");
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String searchName = request.getParameter("searchName");
        String searchAddress = request.getParameter("searchAddress");
        request.setAttribute("txtSearchName", searchName);
        request.setAttribute("txtSearchAddress",searchAddress);
        request.setAttribute("listPosition", iEmployeeService.getAllPosition());
        request.setAttribute("listED", iEmployeeService.getAllEducationDegree());
        request.setAttribute("listDivision", iEmployeeService.getAllDivision());
        request.setAttribute("listEmployee", iEmployeeService.sreachEmployee(searchName,searchAddress));
        request.getRequestDispatcher("/employee/list.jsp").forward(request, response);
    }
}
