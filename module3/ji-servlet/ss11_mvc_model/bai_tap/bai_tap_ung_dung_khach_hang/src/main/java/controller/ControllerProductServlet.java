package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControllerProductServlet", urlPatterns = "/product")
public class ControllerProductServlet extends HttpServlet {
    private static IProductService iProductService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                Integer id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("ten");
                Double gia = Double.parseDouble(request.getParameter("gia"));
                String moTa = request.getParameter("moTa");
                String sanXuat = request.getParameter("sanXuat");
                Product product = new Product(id, name, gia, moTa, sanXuat);
                this.iProductService.save(product);
                response.sendRedirect("/product");
                break;
            case "edit":
                Integer idEdit = Integer.parseInt(request.getParameter("id"));
                String nameEdit = request.getParameter("ten");
                Double giaEdit = Double.parseDouble(request.getParameter("gia"));
                String moTaEdit = request.getParameter("moTa");
                String sanXuatEdit = request.getParameter("sanXuat");
                iProductService.edit(idEdit, nameEdit, giaEdit, moTaEdit, sanXuatEdit);
                response.sendRedirect("/product");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = iProductService.getAll();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request, response);
                break;
            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("id"));
                for (Product p : products) {
                    if (p.getId() == idEdit) {
                        request.setAttribute("id", p.getId());
                        request.setAttribute("ten", p.getName());
                        request.setAttribute("gia", p.getPrice());
                        request.setAttribute("moTa", p.getDescription());
                        request.setAttribute("sanXuat", p.getProducer());
                        request.getRequestDispatcher("edit.jsp").forward(request, response);
                    }
                }
                break;
            case "detele":
                int idDelete = Integer.parseInt(request.getParameter("id"));
                iProductService.delete(idDelete);
                response.sendRedirect("/list.jsp");
                break;
            default:
                request.setAttribute("listProduct", products);
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
        }
    }
}
