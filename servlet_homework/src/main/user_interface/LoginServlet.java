package user_interface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService = UserService.getUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userService.getUser(login);

        if (user == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        if (user.getPassword().equals(password)) {
            request.setAttribute("userFirstName", user.getFirstName());
            request.setAttribute("userLastName", user.getLastName());
            request.setAttribute("userAction", "authorized");

            request.getRequestDispatcher("cabinet.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
