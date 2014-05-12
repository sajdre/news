package newsline;

import com.pvt.CommentService;
import com.pvt.NewsService;
import com.pvt.UserService;
import com.pvt.daoEntities.Comment;
import com.pvt.daoEntities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 12.05.14
 * Time: 1:11
 * To change this template use File | Settings | File Templates.
 */
public class AddComment extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserService us = new UserService();
        User user = (User)session.getAttribute("user");
        String commentText = request.getParameter("comment");
        if((commentText != null) && us.isUser(user)){
            NewsService ns = new NewsService();
            CommentService cs = new CommentService();
            Comment comment = new Comment();
            comment.setComment(commentText);
            comment.setUser_id(user.getId());
            Integer newsId = Integer.parseInt(request.getParameter("newsid"));
            comment.setNews_id(newsId);
            comment.setNumber(cs.getCurrentNumberOfComment(newsId));
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            comment.setDate(dateFormat.format(date));
            cs.save(comment);
            try {
                response.sendRedirect("/site/?operation=shownews&id=" + newsId);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
