# 🏨 Hostel Management System

This is a simple web-based Hostel Management System created to demonstrate my knowledge of **JSP**, **Servlets**, **JDBC**, **HTML/CSS**, and **web application development in Java**.

---

## 💡 Key Concepts Demonstrated

- Use of **Servlets** extending `HttpServlet` (GET & POST handling)
- Use of **`HttpSession`** for session tracking after login
- **`RequestDispatcher`** for server-side page redirection (used in login logic)
- **`sendRedirect()`** to client-side redirect to the hostel location page
- **JDBC** connection using **`PreparedStatement`** and **`executeQuery()`** for secure DB operations
- JSP file (`hostel.jsp`) to display dynamic hostel content after login
- Registration and login flow handled fully using Java backend

---

## 🧰 Technologies Used

- Java
- Servlets (Jakarta EE)
- JSP (JavaServer Pages)
- HTML5 / CSS3
- JDBC (MySQL database)
- Apache Tomcat (Servlet container)

---

## 📁 Project Structure

src/
└── main/
├── java/
│ └── com/ssp/
│ ├── Hostel.java
│ ├── Location.java
│ ├── Login.java
│ └── Studentregi.java
└── webapp/
├── META-INF/
├── WEB-INF/
├── hostel.jsp
├── location.html
├── login.html
├── Registration.html
├── Dal.jpg
├── poha.jpg
├── rice.jpg
└── script.js

## 🔁 How the Project Works

1. **Registration**  
   - User fills the form in `Registration.html`
   - Handled by `Studentregi.java` using JDBC and `PreparedStatement`

2. **Login**  
   - User logs in via `login.html`
   - Handled by `Login.java`
   - Uses `RequestDispatcher` for validation and forwards to `hostel.jsp` on success

3. **Session Management**  
   - Session is created on successful login using `HttpSession`
   - User remains logged in until session expires

4. **Hostel Location**  
   - Servlet `Location.java` uses `sendRedirect()` to open `location.html` which shows map/location details
