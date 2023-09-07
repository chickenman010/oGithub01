package och01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// HW
/**
 * Servlet implementation class Board
 */
@WebServlet("/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		Date date1 = new Date();
		String content = request.getParameter("content");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>게시판</h1>");
		out.printf("<h4>제목 : %s</h4>",title);
		out.printf("<h4>작성자 : %s</h4>",writer);
		out.printf("<h4>작성일 :"+ date1+"</h4>");
		out.printf("<h4>내용 : %s</h4>",content);
		out.println("</body></html>");
		
		
	}

}
