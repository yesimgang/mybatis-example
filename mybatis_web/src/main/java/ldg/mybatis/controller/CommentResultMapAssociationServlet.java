package ldg.mybatis.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import ldg.mybatis.model.CommentUser;
import ldg.mybatis.service.CommentResultMapService;

@SuppressWarnings("serial")
public class CommentResultMapAssociationServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long commentNo = Long.parseLong(req.getParameter("commentNo"));

		CommentResultMapService commentService = new CommentResultMapService();
		CommentUser comment = commentService.selectCommentByPrimaryKeyAssociation(commentNo);

		req.setAttribute("result", comment);
		RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
		dispatcher.forward(req, resp);
	}
}
