package next.controller;

import next.model.User;

import javax.servlet.http.HttpSession;

/**
 * Created by jyami on 2020/09/19
 */
public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "user";

    public static User getUserFromSession(HttpSession session) {
        Object user = session.getAttribute(USER_SESSION_KEY);
        if (user == null) {
            return null;
        }
        return (User) user;
    }

    public static boolean isLogined(HttpSession session) {
        if (getUserFromSession(session) == null) {
            return false;
        }
        return true;
    }

    public static boolean isSameUser(HttpSession session, User user) {
        if (!isLogined(session)) {
            return false;
        }

        if (user == null) {
            return false;
        }

        return user.isSameUser(getUserFromSession(session));
    }

    public static boolean isSameUser(HttpSession session, String userId) {
        if (!isLogined(session)) {
            return false;
        }

        if (userId == null) {
            return false;
        }

        return getUserFromSession(session).isSameUser(userId);
    }
}
