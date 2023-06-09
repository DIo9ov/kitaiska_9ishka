
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;

@WebServlet(urlPatterns = {"/RegServlet"})
public class RegServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String r = """
                   <!DOCTYPE>
                   <html>
                    <head>
                        <title>Jazzvezdi</title>
                        <meta charset="UTF-8">
                    </head>
                    <body>
                        <p>Успешна регистрация!</p>
                    </body>
                   </html>
                   
                   """;
       // response.getWriter().println(r);
       String db = "jdbc:mariadb://localhost/jazovci";
       String regIme = request.getParameter("ime");
       String regPass = request.getParameter("pass");
       
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection(db);
            Statement stmt = conn.createStatement();
            String query = """
                           INSERT INTO potreb (ime,pass) 
                           VALUES (\"%s\",\"%s\");           
                           """.formatted(regIme, regPass);
            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       // response.sendRedirect("index.html");
     
    }

}
