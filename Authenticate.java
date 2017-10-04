

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet(urlPatterns = { "/Authenticate" })
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Authenticate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Servlet");
		PrintWriter writer = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		String tbName=null;
		
		if (email!="" &&  email!=null){
			session.setAttribute("savedUserName",email);
			context.setAttribute("savedUserName",email);
		}
		//System.out.println(password);
	    //writer.println("hello "+password);
		/*int id = Authentication(email,password);*/
		Authenticator auth = new Authenticator();
		int id=auth.checkCredentials(email, password);
		
		
		if(id==-1){
			//writer.println("<script> alert(\"Incorrect username or password\"); </script>");
			response.sendRedirect("blogerr.html");}
			
		 if(id>0) {
			 writer.println("<!DOCTYPE html> <html lang=\"en\"> <head> <meta charset=\"utf-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <title>MANAGEMENT APPLICATION</title> <!-- Bootstrap --> <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"> <link href=\"css/responsive-slider.css\" rel=\"stylesheet\"> <link rel=\"stylesheet\" href=\"css/animate.css\"> <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\"> <link href=\"css/style.css\" rel=\"stylesheet\"> <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries --> <!-- WARNING: Respond.js doesn't work if you view the page via file:// --> <!--[if lt IE 9]> <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script> <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script> <![endif]--> </head> <body> <header> <div class=\"container\"> <div class=\"row\"> <nav class=\"navbar navbar-default\" role=\"navigation\"> <div class=\"container-fluid\"> <div class=\"navbar-header\"> <div class=\"navbar-brand\"> <h1>");
			 writer.println(email+ "\"</h1></a> </div> </div> <div class=\"menu\"> <ul class=\"nav nav-tabs\" role=\"tablist\"> <li role=\"presentation\" class=\"active\"><a href=\"index.html\">HOME</a></li> <!--<li role=\"presentation\"><a href=\"feature.html\">Feature</a></li>--> <li role=\"presentation\"><a href=\"blog.html\">LOGIN</a></li> <li role=\"presentation\"><a href=\"portfolio.html\">Portfolio</a></li> <li role=\"presentation\"><a href=\"contact.html\">SIGN UP</a></li> </ul> </div> </div> </nav> </div> </div> </header> <!-- Responsive slider - START --> <div class=\"slider\"> <div class=\"\"> <div class=\"\"> <div class=\"responsive-slider\" data-spy=\"responsive-slider\" data-autoplay=\"true\"> <div class=\"slides\" data-group=\"slides\"> <ul> <li> <div class=\"slide-body\" data-group=\"slide\"> <img src=\"img/3.jpg\" alt=\"\" class=\"img-responsive\" > </div> </li> <li> <div class=\"slide-body\" data-group=\"slide\"> <img src=\"img/6.jpg\" alt=\"\" class=\"img-responsive\" > </div> </li> <li> <div class=\"slide-body\" data-group=\"slide\"> <img src=\"img/5.jpg\" alt=\"\" class=\"img-responsive\" > </div> </li> </ul> </div> <a class=\"slider-control left\" href=\"#\" data-jump=\"prev\"><i class=\"fa fa-angle-left fa-2x\"></i></a> <a class=\"slider-control right\" href=\"#\" data-jump=\"next\"><i class=\"fa fa-angle-right fa-2x\"></i></a> </div> </div> </div> </div> <!-- Responsive slider - END --> <div class=\"content\"> <h2><span>FREE ,EASY ,YOU CAN START TODAY</span></h2> <p> IT IS A WEB APPLICATION THAT CAN HELP YOU TO MANAGE YOUR BUSINESS </p> </div> <div class=\"breadcrumb\"> <h4>IMPORTANT FEATURES</h4> </div> <div class=\"container\"> <div class=\"row\"> <div class=\"boxs\"> <div class=\"col-md-4\"> <div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"0.8s\"> <div class=\"align-center\"> <h4>Quick Support</h4> <div class=\"icon\"> <i class=\"fa fa-heart-o fa-3x\"></i> </div> <p> WE ARE THERE FOR YOU 24*7 </p> <div class=\"ficon\"> <a href=\"\" alt=\"\">Learn more</a> </div> </div> </div> </div> <div class=\"col-md-4\"> <div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"1.3s\"> <div class=\"align-center\"> <h4>SAFE AND SECURE </h4> <div class=\"icon\"> <i class=\"fa fa-desktop fa-3x\"></i> </div> <p> YOUR INFORMATION WILL REMAIN SAFE AND SECURE. </p> <div class=\"ficon\"> <!--<a href=\"\" alt=\"\">Learn more</a> --> </div> </div> </div> </div> <div class=\"col-md-4\"> <div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"1.3s\"> <div class=\"align-center\"> <h4></h4> <div class=\"icon\"> <i class=\"fa fa-location-arrow fa-3x\"></i> </div> <p> ACCESS FROM ANYWHERE. </p> <div class=\"ficon\"> <a href=\"\" alt=\"\">Learn more</a> </div> </div> </div> </div> </div> </div> </div> <div class=\"container\"> <div class=\"row\"> <div class=\"bg\"> <div class=\"col-md-4\"> <div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"0.8s\"> <div class=\"align-center\"> <h4>MANAGE</h4> <div class=\"icon\"> <i class=\"fa fa-heart-o fa-3x\"></i> </div> <p> YOU CAN EASILY MANAGE YOUR ACCOUNTS. </p> <div class=\"ficon\"> <a href=\"\" alt=\"\">Learn more</a> </div> </div> </div> </div> <div class=\"col-md-4\"> <div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"1.3s\"> <div class=\"align-center\"> <h4>EASY</h4> <div class=\"icon\"> <i class=\"fa fa-laptop fa-3x\"></i> </div> <p> VERY EASY TO MANGE YOUR RECORDS </p> <div class=\"ficon\"> <a href=\"\" alt=\"\">Learn more</a> </div> </div> </div> </div> <div class=\"col-md-4\"> <div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"1.3s\"> <div class=\"align-center\"> <h4>Easy Customize</h4> <div class=\"icon\"> <i class=\"fa fa-cloud fa-3x\"></i> </div> <p> </p> <div class=\"ficon\"> <a href=\"\" alt=\"\">Learn more</a> </div> </div> </div> </div> </div> </div> </div> <div class=\"breadcrumb\"> <h4>About Us</h4> </div> <div class=\"container\"> <div class=\"row\"> <div class=\"\"> <div class=\"col-md-7\"> <div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"0.8s\"> <img src=\"./img/group.jpg\" alt=\"\" class=\"img-responsive\"> </div> </div> <div class=\"col-md-5\"> <div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"1.3s\"> <div class=\"list-group\"> <a href=\"#\" class=\"list-group-item active\"> <h4 class=\"list-group-item-heading\">ANURAG SHARMA</h4> <p class=\"list-group-item-text\">praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias </p> </a> <div class=\"list-group-item\"> <h4 class=\"list-group-item-heading\">ANUJ VARSHNEY</h4> <p class=\"list-group-item-text\">praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias </p> </div> <div class=\"list-group-item\"> <h4 class=\"list-group-item-heading\">AKASH PAREKH</h4> <p class=\"list-group-item-text\">praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias </p> </div> <div class=\"list-group-item\"> <h4 class=\"list-group-item-heading\">ABHISHEK GUPTA</h4> <p class=\"list-group-item-text\">praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias </p> </div> <div class=\"list-group-item\"> <h4 class=\"list-group-item-heading\">ADARSH SHARMA</h4> <p class=\"list-group-item-text\">praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias </p> </div> </div> </div> </div> </div> </div> </div> <!--<div class=\"container\">--> <!--<div class=\"row\">--> <!--<div class=\"\"> --> <!--<div class=\"col-md-4\">--> <!--<div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"0.8s\">--> <!--<div class=\"list-group\">--> <!--<a href=\"#\" class=\"list-group-item active\">--> <!--<h4 class=\"list-group-item-heading\">ANURAG SHARMA</h4>--> <!--<p class=\"list-group-item-text\">praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias --> <!--</p>--> <!--</a>--> <!--<div class=\"list-group-item\">--> <!--<h4 class=\"list-group-item-heading\">ANUJ VARSHNEY</h4>--> <!--<p class=\"list-group-item-text\">praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias --> <!--</p> --> <!--</div>--> <!--<div class=\"list-group-item\">--> <!--<h4 class=\"list-group-item-heading\">AKASH PAREKH</h4>--> <!--<p class=\"list-group-item-text\">praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias --> <!--</p> --> <!--</div>--> <!--<div class=\"list-group-item\">--> <!--<h4 class=\"list-group-item-heading\">ADARSH SHARMA</h4>--> <!--<p class=\"list-group-item-text\">praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias --> <!--</p> --> <!--</div>--> <!--</div>--> <!--</div>--> <!--</div>--> <!--<div class=\"col-md-8\">--> <!--<div class=\"image\">--> <!--<div class=\"wow bounceIn\" data-wow-offset=\"0\" data-wow-delay=\"1.3s\"> --> <!--<img src=\"img/5.jpg\" alt=\"\" class=\"img-responsive\"> --> <!--</div>--> <!--</div>--> <!--</div>--> <!--</div>--> <!--</div>--> <!--</div>--> <hr> <!--start footer--> <footer> <div class=\"container\"> <div class=\"row\"> <div class=\"col-lg-4\"> <div class=\"widget\"> <h5 class=\"widgetheading\">Nam libero tempore</h5> <p>soluta nobis est eligendi optio cumque nihil impedit quo minus id excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui </p> </div> </div> <div class=\"col-lg-4\"> <div class=\"widget\"> <h5 class=\"widgetheading\">IMPORTANT INFORMATION</h5> <ul class=\"link-list\"> <li><a href=\"#\"> GST</a></li> <li><a href=\"#\"> GST NUMBER</a></li> <li><a href=\"#\"> TIN NUMBER</a></li> <li><a href=\"#\">CONTACT US</a></li> <li><a href=\"#\">TERMS AND CONDITIONS</a></li> </ul> </div> </div> <div class=\"col-lg-4\"> <div class=\"widget\"> <h5 class=\"widgetheading\">QUICK RESPONSE</h5> <ul class=\"link-list\"> <li><a href=\"#\">LATEST TECHNOLOGY</a></li> <li><a href=\"#\"></a></li> <!--<li><a href=\"#\">Natus error sit voluptatem </a></li>--> </ul> </div> </div> </div> </div> <div class=\"sub-footer\"> <div class=\"container\"> <div class=\"row\"> <div class=\"col-lg-12\"> <ul class=\"social-network\"> <li><a href=\"#\" data-placement=\"top\" title=\"Facebook\"><i class=\"fa fa-facebook fa-1x\"></i></a></li> <li><a href=\"#\" data-placement=\"top\" title=\"Twitter\"><i class=\"fa fa-twitter fa-1x\"></i></a></li> <li><a href=\"#\" data-placement=\"top\" title=\"Linkedin\"><i class=\"fa fa-linkedin fa-1x\"></i></a></li> <li><a href=\"#\" data-placement=\"top\" title=\"Pinterest\"><i class=\"fa fa-pinterest fa-1x\"></i></a></li> <li><a href=\"#\" data-placement=\"top\" title=\"Google plus\"><i class=\"fa fa-google-plus fa-1x\"></i></a></li> </ul> </div> <div class=\"col-lg-12\"> <div class=\"copyright\"> <p> <span>&copy;ANURAG AND TEAM</span><a href=\"http://bootstraptaste.com\" target=\"_blank\"></a> </p> <!-- All links in the footer should remain intact. Licenseing information is available at: http://bootstraptaste.com/license/ You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Resi --> </div> </div> </div> </div> </div> </footer> <!--end footer--> <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> <script src=\"js/jquery-2.1.1.min.js\"></script> <!-- Include all compiled plugins (below), or include individual files as needed --> <script src=\"js/bootstrap.min.js\"></script> <script src=\"js/responsive-slider.js\"></script> <script src=\"js/wow.min.js\"></script> <script> wow = new WOW( { } ) .init(); </script> </body> </html> ");//response.sendRedirect("index.html");
			 
		 }
		
		
	

	}}
