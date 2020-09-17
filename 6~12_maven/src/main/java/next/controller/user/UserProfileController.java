package next.controller.user;

import core.mvc.*;
import next.dao.UserDao;
import next.model.CurrentUserChecker;
import next.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by jyami on 2020/09/05
 */
public class UserProfileController extends AbstractController {

    private UserDao userDao = new UserDao();

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
        Optional<User> currentUser = CurrentUserChecker.getCurrentUser(request);
        if (!currentUser.isPresent()) {
            return jspView("redirect:/user/login");
        }

        String userId = request.getParameter("userId");
        User user = userDao.findByUserId(userId);
        return jspView("/user/profile.jsp").addObject("user", user);
    }
}
