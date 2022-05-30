import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@javax.servlet.annotation.WebServlet(name = "CurrencyConverterServlet", urlPatterns = "/doiTien")
public class CurrencyConverterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));
        float vnd = rate * usd;
        request.setAttribute("rate",rate );
        request.setAttribute("usd",usd );
        request.setAttribute("vnd", vnd );
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
