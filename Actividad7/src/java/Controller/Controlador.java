package Controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    private void doBeforeProcessing(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(request.getAttribute("Error")!=null){
                request.setAttribute("Error", true);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }else{
                String n1 = request.getParameter("Base");
            String n2 = request.getParameter("Altura");
            String Username = request.getParameter("Username");
            Model.Suma s = new Model.Suma(n1, n2);
            s.hacerSuma();
            Cookie ck = new Cookie("Base", s.getNum1()+"");
            response.addCookie(ck);
            ck = new Cookie("Altura", s.getNum2()+"");
            response.addCookie(ck);
            ck = new Cookie("Area", s.getResultado()+"");
            response.addCookie(ck);
            ck = new Cookie("Perimetro", s.getPerimetro()+"");
            response.addCookie(ck);
            
            HttpSession sesion = request.getSession(false);
            sesion.setAttribute("Username", Username);
            
            int resultado = s.getResultado();
            request.setAttribute("sumaResuelta", s);
            request.getRequestDispatcher("/Resultado.jsp").forward(request, response);

            }            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
