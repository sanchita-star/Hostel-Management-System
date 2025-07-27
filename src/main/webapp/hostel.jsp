<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String eml = (String) request.getAttribute("Email");
    String np = (String) request.getAttribute("newpass");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hostel Homepage</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            background-color: #2c3e50;
            color: white;
            padding: 10px 20px;
        }

        .profile {
            display: flex;
            align-items: center;
        }

        .profile img {
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
        }

        .sidebar {
            width: 200px;
            position: fixed;
            top: 60px;
            left: 0;
            height: 100%;
            background-color: #34495e;
            padding-top: 20px;
            color: white;
        }

        .sidebar a {
            display: block;
            padding: 12px 20px;
            color: white;
            text-decoration: none;
            cursor: pointer;
        }

        .sidebar a:hover {
            background-color: #3c5978;
        }

        .content {
            margin-left: 220px;
            padding: 20px;
        }

        .section {
            padding: 10px;
        }

        .section-wrapper {
            max-width: 800px;
            margin: 0 auto;
        }

        .food-img {
            width: 100%;
            max-width: 600px;
            height: auto;
            border-radius: 10px;
            margin: 10px 0;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        h2 {
            color: #2c3e50;
        }
    </style>

    <script>
        function showSection(id) {
            let sections = document.querySelectorAll('.section');
            sections.forEach(sec => sec.style.display = 'none');
            document.getElementById(id).style.display = 'block';
        }

        const jokes = [
            "Why don’t scientists trust atoms? Because they make up everything!",
            "I told my computer I needed a break, and it said 'No problem, I'll crash for you.'",
            "Why was the math book sad? Because it had too many problems."
        ];

        window.onload = function () {
            let jokeIndex = new Date().getDate() % jokes.length;
            document.getElementById("jokeText").innerText = jokes[jokeIndex];
            showSection('mess');
        };
    </script>
</head>
<body>

<div class="navbar">
    <div class="profile">
        <span><%= eml %> | <%= np %></span>
    </div>
    <h1>🏠 SANCHO'S HOSTEL</h1>
</div>

<div class="sidebar">
    <a onclick="showSection('mess')">1. Mess</a>
    <a onclick="showSection('about')">2. About Us</a>
    <a onclick="showSection('contact')">3. Contact Us</a>
    <a onclick="showSection('feedback')">4. Feedback</a>
    <a onclick="showSection('location')">5. Location</a>
    <a onclick="showSection('joke')">6. Joke of the Day</a>
</div>

<div class="content">

    <!-- Mess Section -->
    <div id="mess" class="section">
        <div class="section-wrapper">
            <h2>Today's Menu 🍽</h2>
            <p><strong>Breakfast:</strong> Poha, Tea</p>
            <img class="food-img" src="poha.jpg" alt="Poha">

            <p><strong>Lunch:</strong> Rice, Dal, Sabzi, Chapati</p>
            <img class="food-img" src="rice.jpg" alt="Lunch">

            <p><strong>Tea (5 PM):</strong> Chai + Biscuits</p>

            <p><strong>Dinner:</strong> Dal Khichadi + Lonch</p>
            <img class="food-img" src="Dal.jpg" alt="Dinner">
        </div>
    </div>

    <!-- About Section -->
    <div id="about" class="section" style="display:none;">
        <div class="section-wrapper">
            <h2>About Our Hostel 🏠</h2>
            <p>Welcome to DCCL Hostel — a peaceful, hygienic, and secure place to stay and study. We strive to provide a friendly environment and quality facilities.</p>
        </div>
    </div>

    <!-- Contact Section -->
    <div id="contact" class="section" style="display:none;">
        <div class="section-wrapper">
            <h2>Contact Us 📞</h2>
            <p><strong>Name:</strong> Sanchita Patil</p>
            <p><strong>Address:</strong> Karadkhel</p>
            <p><strong>Phone:</strong> 1111111111</p>
            <p><strong>Instagram:</strong> <a href="https://instagram.com/your_id" target="_blank">@sanchita_id</a></p>
            <p><strong>Email:</strong> sanchita@example.com</p>
        </div>
    </div>

    <!-- Feedback Section -->
    <div id="feedback" class="section" style="display:none;">
        <div class="section-wrapper">
            <h2>Feedback 📝</h2>
            <form action="mailto:sanchita@example.com" method="post" enctype="text/plain">
                <label>Your Feedback:</label><br>
                <textarea name="feedback" rows="5" cols="40" required></textarea><br><br>
                <input type="submit" value="Send Feedback">
            </form>
        </div>
    </div>

    <!-- Location Section -->
    <div id="location" class="section" style="display:none;">
        <div class="section-wrapper">
            <jsp:include page="location.html" />
        </div>
    </div>

    <!-- Joke Section -->
    <div id="joke" class="section" style="display:none;">
        <div class="section-wrapper">
            <h2>Joke of the Day 😄</h2>
            <p id="jokeText"></p>
        </div>
    </div>

</div>

</body>
</html>