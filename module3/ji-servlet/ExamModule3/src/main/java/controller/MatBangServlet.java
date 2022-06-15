package controller;

import model.service.IMatBangService;
import model.service.Impl.MatBangServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MatBangServlet", urlPatterns = "/home")
public class MatBangServlet extends HttpServlet {
    private static IMatBangService iMatBangService = new MatBangServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action= "";
        }switch (action){
            case "create":
                request.setAttribute("listMatBang",iMatBangService.getAllMatBang());
                request.setAttribute("listLoaiMatBang",iMatBangService.getAllLoaiMatBang());
                request.setAttribute("listTrangThai",iMatBangService.getAllTrangThai());
                request.getRequestDispatcher("/list.jsp").forward(request,response);   
                break;
            case "search":
                 showSearch(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            default:
                showMatBang(request, response);
                break;
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer searchLoaiMatBang = Integer.valueOf(request.getParameter("loaiMatBang"));
        Double searchGiaTien = Double.valueOf(request.getParameter("giaTien"));
        Integer searchTang = Integer.valueOf(request.getParameter("tang"));
        request.setAttribute("txtSearchLoai", searchLoaiMatBang);
        request.setAttribute("txtSearchGia",searchGiaTien);
        request.setAttribute("txtSearchTang",searchTang);
        request.setAttribute("listMatBang",iMatBangService.getAllMatBang());
        request.setAttribute("listLoaiMatBang",iMatBangService.getAllLoaiMatBang());
        request.setAttribute("listTrangThai",iMatBangService.getAllTrangThai());
        request.setAttribute("listEmployee", iMatBangService.sreachMatBang(searchLoaiMatBang,searchGiaTien,searchTang));
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maDelete = request.getParameter("maDelete");
        iMatBangService.delete(maDelete);
        response.sendRedirect("/home");
    }

    private void showMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listMatBang",iMatBangService.getAllMatBang());
        request.setAttribute("listLoaiMatBang",iMatBangService.getAllLoaiMatBang());
        request.setAttribute("listTrangThai",iMatBangService.getAllTrangThai());
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
