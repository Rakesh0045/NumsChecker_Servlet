# NumsChecker

NumsChecker is a simple Java-based web application built using **GenericServlet**, JSP, and basic HTML. It allows users to input a number and perform various checks such as Prime, Perfect, Armstrong, Strong, Spy, and Palindrome. The results are displayed on a clean and responsive UI.

## Features
- Input a number and select checks to perform.
- Supported checks:
  - Prime
  - Perfect
  - Armstrong
  - Strong
  - Spy
  - Palindrome
- Results are displayed on a styled output page.
- A "How It Works" page explains the logic behind each check with examples.

## Project Structure
```
NumsChecker/
│
├── WebContent/
│   ├── index.html             
│   ├── how-it-works.html      
│   ├── output.jsp             
│   ├── styles.css                 
│   ├── bg.jpg                
│
├── WEB-INF/
│   ├── web.xml                
│   ├── lib/                   
└── src/
     └── CheckNumberServlet.java 
```

## Technologies Used
- **Java Servlet**: Core logic
- **JSP**: Dynamic result rendering
- **HTML & CSS**: Front-end interface
- **Apache Tomcat**: Server for deployment

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/NumsChecker.git
   ```
2. Open the project in your IDE (e.g., Eclipse or IntelliJ IDEA).
3. Deploy the project on an Apache Tomcat server.
4. Access the application at `http://localhost:8080/NumsChecker/`.
