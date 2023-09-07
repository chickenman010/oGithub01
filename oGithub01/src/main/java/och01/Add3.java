package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3") // <-Annotation 주소역할. 없으면 찾아가지 못함
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */									// request에 num,loc 정보를 담음      response = 뿌려줄 정보   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("이미 Up 내용을 수정....");
		
		// Parameter 받기           request.getParameter로 num과 loc값을 받아서 num, loc에 담음
		int num = Integer.parseInt(request.getParameter("num"));	// 문자열인 숫자를 int형으로 바꿔서 담음
		String loc = request.getParameter("loc");
		System.out.println("num->"+num);
		System.out.println("loc->"+loc);
		
		// 목표 : 1부터 누적값 전달
		int sum = 0;
		for (int i = 1; i<=num; i++) {
			sum += i;
		}
		System.out.println("sum->"+sum);
		
		// Encoding 적용 (한글을 나오게하는 메소드)
		// request.setCharacterEncoding("utf-8");           // get방식에는 request 인코딩이 필요하지않음
		response.setContentType("text/html;charset=utf-8"); // get방식에는 response 인코딩이 필요함
		
		// 사용자 브라우저에 보여주는 객체 (= 공식)
		PrintWriter out = response.getWriter(); // response객체의 getWriter메소드를 호출
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 합계</h1>",num);
		out.printf("<h4>LOC--> %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 여기왔네");
		// Post방식은 request parameter 받기 전에 Encoding 적용
		request.setCharacterEncoding("utf-8");
		// Parameter 받기           request.getParameter로 num과 loc값을 받아서 num, loc에 담음
		int num = Integer.parseInt(request.getParameter("num")); // 문자열인 숫자를 int형으로 바꿔서 담음
		String loc = request.getParameter("loc");
		System.out.println("num->"+num);
		System.out.println("loc->"+loc);
				
		// 목표 : 1부터 누적값 전달
		int sum = 0;
		for (int i = 1; i<=num; i++) {
			sum += i;
		}
		System.out.println("sum->"+sum);
			
		// Encoding 적용 (한글을 나오게하는 메소드)
		response.setContentType("text/html;charset=utf-8"); // post방식에는 request, response 둘 다 필요함
		
		// 사용자 브라우저에 보여주는 객체 (= 공식)
		PrintWriter out = response.getWriter(); // response객체의 getWriter메소드를 호출
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 Post 합계</h1>",num);
		out.printf("<h4>LOC--> %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();		
	}

}
