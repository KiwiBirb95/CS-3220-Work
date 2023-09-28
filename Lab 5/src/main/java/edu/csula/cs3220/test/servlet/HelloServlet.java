uipackage edu.csula.cs3220.test.servlet;

import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = dateFormat.parse("2/14/2023");
            date2 = dateFormat.parse("6/15/2023");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create two Event objects
        Event event1 = new Event("Room 19 Valentine Party", date1, "Amy Frank");
        Event event2 = new Event("Room 19 Kindergarten Graduation", date2, "Amy Frank");

        // Create a list to hold the events
        List<Event> eventList = new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);

        // Get the ServletContext (application scope) and set the eventList attribute
        ServletContext context = getServletContext();
        context.setAttribute("eventList", eventList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the eventList from the application scope
        ServletContext context = getServletContext();
		List<Event> eventList = (List<Event>) context.getAttribute("eventList");

        // Set the content type to HTML
        response.setContentType("text/html");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

        // Generate the HTML page with the table
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Events</h1>");
        response.getWriter().println("<a href='#' style='margin-bottom: 20px; display: block;'>New Events</a>");
        response.getWriter().println("<table style='border-collapse: collapse; border: 1px solid black;'>");
        response.getWriter().println("<tr>");
        response.getWriter().println("<th style='font-weight: bold; border: 1px solid black; padding: 8px;'>Event</th>");
        response.getWriter().println("<th style='font-weight: bold; border: 1px solid black; padding: 8px;'>Date</th>");
        response.getWriter().println("<th style='font-weight: bold; border: 1px solid black; padding: 8px;'>Created By</th>");
        response.getWriter().println("</tr>");

        // Loop through the eventList and populate the table rows
        for (Event event : eventList) {
        	String formattedDate = dateFormat.format(event.getEventDate());
            response.getWriter().println("<tr>");
            response.getWriter().println("<td style='border: 1px solid black; padding: 8px;'>" + event.getName() + "</td>");
            response.getWriter().println("<td style='border: 1px solid black; padding: 8px;'>" + formattedDate + "</td>");
            response.getWriter().println("<td style='border: 1px solid black; padding: 8px;'>" + event.getCreatedBy() + "</td>");
            response.getWriter().println("</tr>");
        }

        response.getWriter().println("</table>");
        response.getWriter().println("</body></html>");
    }

}
