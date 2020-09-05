package next.controller.user;

import core.mvc.Controller;
import next.dao.UserDao;
import next.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jyami on 2020/08/27
 */
public class CreateUserController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(request.getParameter("userId"), request.getParameter("password"),
                request.getParameter("name"), request.getParameter("email"));

        new UserDao().insert(user);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "redirect:/user/list";
    }
}
