<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Output - NumsChecker</title>
    <style>
        body {
            background-color: indigo;
            color: white;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.7);
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
            text-align: center;
        }

        .results {
            list-style-type: none;
            padding: 0;
            margin-bottom: 20px;
        }

        .results li {
            margin-bottom: 10px;
        }

        .go-back,
        .how-it-works {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }

        .go-back:hover,
        .how-it-works:hover {
            background-color: #45a049;
        }

        .how-it-works {
            margin-left: 10px;
            background-color: #1E90FF;
        }
    </style>
</head>

<body>
    <div class="container">
        <h2>Results for Number: ${number}</h2>
        <ul class="results">
            <%
			    Map<String, String> results = (Map<String, String>) request.getAttribute("results");
			    if (results != null && results.isEmpty()) {
			        out.println("<p>No checks were selected.</p>");
			    } else {
			        // existing code to display results
			        for (Map.Entry<String, String> entry : results.entrySet()) {
			%>
			    <li><b><%= entry.getKey() %>:</b> <%= entry.getValue() %></li>
			<%
			        }
			    }
			%>
            
        </ul>
        <a href="index.html" class="go-back">Go Back</a>
        <a href="howitworks.html" class="how-it-works">How It Works</a> <!-- Link to How It Works page -->
    </div>
</body>

</html>
