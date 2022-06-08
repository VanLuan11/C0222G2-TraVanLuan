package controller;

import model.model.service.Service;
import model.service.IService;
import model.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private static IService iService = new ServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String serviceName = request.getParameter("service_name");
                int serviceArea = Integer.parseInt(request.getParameter("service_area"));
                double serviceCost = Double.parseDouble(request.getParameter("service_cost"));
                int serviceMaxPeople = Integer.parseInt(request.getParameter("service_max_people"));
                int rentTypeId = Integer.parseInt(request.getParameter("rent_type_id"));
                int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
                String standardRoom =  request.getParameter("standard_room");
                String descriptionOC =  request.getParameter("description_other_convenience");
                double poolArea = Double.parseDouble(request.getParameter("pool_area"));
                int numberOfFloors = Integer.parseInt(request.getParameter("number_of_floors"));
                Service service = new Service(serviceName,serviceArea,serviceCost,serviceMaxPeople,rentTypeId,serviceTypeId,standardRoom,descriptionOC,poolArea,numberOfFloors);
                iService.create(service);
                response.sendRedirect("/service");
                break;
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
            default:
                request.setAttribute("listService",iService.getALlService());
                request.getRequestDispatcher("/service/list.jsp").forward(request,response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listServiceType",iService.getAllServiceType());
        request.setAttribute("listRentType",iService.getAllRentType());
        request.getRequestDispatcher("/service/list.jsp").forward(request,response);
    }
}
