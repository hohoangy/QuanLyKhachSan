<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABOUT</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
</head>

<body>
    <!-- <div class="preloader">
        <div></div>
        <div>Loading Content!</div>
    </div> -->
    
    <header>
        <input type="checkbox" id="toggle-check">
        <nav>
            <div class="container">
                <h1>Hotel</h1>

                <ul>
                    <li><a href="Index.jsp">Home</a></li>
                    <li><a href="About.jsp" class="current">About</a></li>
                    <li><a href="Contact.jsp">Contact</a></li>
                    <li><a href="Login.jsp">Login</a></li>
                </ul>

                <div class="toggle">
                    <label for="toggle-check" class="toggle-btn"><span></span></i></label>
                </div>
            </div>
        </nav>
    </header>

    <main>
        <section class="about">
            <div class="container">
                <article class="text-content">
                    <h1><span class="color-primary">About</span> the Hotel</h1>
                    <p>"ATHENA HOTEL is a 4-star international hotel with 148 rooms with full facilities and services, including 11 luxurious bedrooms. All of them are elegantly designed not only for aesthetics but also for aesthetic purposes. Experience the combination and comfort. The brilliant decoration interweaves Vietnamese culture and art with modern architectural art to meet the expectations of all merchants and tourists."
                    </p>
                    <p>In addition, the hotel also has a Cheery bar, a Health Club area including sauna, Jacuzzi, karaoke, relaxation room, massage area ... will help you relax after stressful working days.
                    </p>
                    <p>ATHENA HOTEL was built on a total area of ​​4,300m2, located in the city center and opposite the beautiful Quy Nhon beach.</p>
                </article>

                <article class="image"></article>
            </div>
        </section>

        <section class="testimonials">
            <div class="transparent-layer"></div>
            <div class="container">
                <h1>What the Guests Say</h1>

                <article>
                    <div class="image"><img src="../resources/img/Yoonaa.jpg" alt="Dylan-Moran"></div>
                    <p>Everybody is corrupted by hotel rooms. You can't help it. It's the only place in the world where
                        you walk in and the first thing you do is steal everything before you take your coat off.</p>
                </article>

                <article>
                    <div class="image"><img src="../resources/img/Lee-Jong-Suk.jpg" alt="George-Yeo"></div>
                    <p>What we need are individuals and families who feel a responsibility to help build and to help run
                        the hotel. When that happens the hotel becomes a home.</p>
                </article>
            </div>
        </section>
    </main>

    <footer>
        <div class="container">
            <p>&copy;All Rights Reserved by ATHENA HOTEL.</p>
        </div>
    </footer>

    <script src="<%= request.getContextPath() %>/resources/js/script.js"></script>
</body>

</html>