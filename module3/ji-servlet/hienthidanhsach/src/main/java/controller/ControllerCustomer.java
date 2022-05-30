package controller;

import model.Customer;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "ControllerCustomer", urlPatterns = "/list")
public class ControllerCustomer extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer("lệ thị tài","11/2/1990","Đà Nẵng","https://s.memehay.com/files/posts/20210119/cho-cute-chi-hai-tay-vao-nhau-it-is-for-me.jpg");
        customers[1] = new Customer("lệ thị tài","11/2/1990","Đà Nẵng","https://i.pinimg.com/564x/2d/2f/8b/2d2f8b0c5454dfd98144f3c86b65b6ab.jpg");
        customers[2] = new Customer("lệ thị tài","11/2/1990","Đà Nẵng","https://memehay.com/meme/20210613/cho-co-doi-mat-tron-thanh-hinh-hai-dau-hoi.webp");
        customers[3] = new Customer("lệ thị tài","11/2/1990","Đà Nẵng","https://ben.com.vn/tin-tuc/wp-content/uploads/2021/12/anh-che-cho-hai-huoc-cho-dien-thoai-4.jpg");
        customers[4] = new Customer("lệ thị tài","11/2/1990","Đà Nẵng","https://s.memehay.com/files/posts/20210311/ma-thoi-ban-oi-bo-di-ma-lam-cho-hay-ho-gi-cai-do-dau-ma.jpg");
        request.setAttribute("listCustomer",customers);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
