package next.controller.user;

import core.mvc.Controller;
import next.dao.UserDao;
import next.model.CurrentUserChecker;
import next.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * Created by jyami on 2020/09/05
 */
public class UserProfileController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Optional<User> currentUser = CurrentUserChecker.getCurrentUser(request);
        if (!currentUser.isPresent()) {
            return "redirect:/user/login";
        }

        String userId = request.getParameter("userId");
        User user = new UserDao().findByUserId(userId);
        request.setAttribute("user", user);
        return "/user/profile.jsp";
    }
}