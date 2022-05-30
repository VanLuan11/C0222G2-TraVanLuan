import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/luan")
public class ConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        int discountPercent = Integer.parseInt(request.getParameter("precent"));
        float discount = (float) (price * discountPercent * 0.01);
        float total = price - discount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Porduct Description " + description + "</h1>");
        writer.println("<h1>Porduct Price " + price + "</h1>");
        writer.println("<h1>Porduct Discount Percent " + discountPercent + "</h1>");
        writer.println("<h1>Porduct Discount " + discount + "</h1>");
        writer.println("<h1>Porduct Total " + total + "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
