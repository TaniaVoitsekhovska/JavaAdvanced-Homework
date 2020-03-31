package user_interface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService = UserService.getUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String accessLevel = null;

        if ("user".equals(request.getParameter("accessLevel"))) {
            accessLevel = AccessLevel.USER.toString();
        } else if ("admin".equals(request.getParameter("accessLevel"))) {
            accessLevel = AccessLevel.ADMIN.toString();
        }

        if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            userService.saveUser(new User(firstName, lastName, email, password, accessLevel));

            request.setAttribute("userFirstName", firstName);
            request.setAttribute("userLastName", lastName);
            request.setAttribute("userAction", "registered");

            request.getRequestDispatcher("cabinet.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
