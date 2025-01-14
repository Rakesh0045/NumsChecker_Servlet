import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class CheckNumberServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // Get number and checks from the request
        String numberStr = req.getParameter("number");
        String[] checks = req.getParameterValues("checkType");

        // Parse the number
        int number = Integer.parseInt(numberStr);
        
        // Prepare the result map
        Map<String, String> results = new HashMap<>();
        
        // Perform the number checks
        if (checks != null) {
            for (String check : checks) {
                switch (check) {
                    case "prime":
                        results.put("Prime", isPrime(number) ? "Yes" : "No");
                        break;
                    case "perfect":
                        results.put("Perfect", isPerfect(number) ? "Yes" : "No");
                        break;
                    case "armstrong":
                        results.put("Armstrong", isArmstrong(number) ? "Yes" : "No");
                        break;
                    case "strong":
                        results.put("Strong", isStrong(number) ? "Yes" : "No");
                        break;
                    case "spy":
                        results.put("Spy", isSpy(number) ? "Yes" : "No");
                        break;
                    case "pallindrome":
                        results.put("Pallindrome", isPalindrome(number) ? "Yes" : "No");
                        break;
                }
            }
        }

        // Set number and results to request
        req.setAttribute("number", number);
        req.setAttribute("results", results);

        // Forward to output.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("output.jsp");
        if (results.isEmpty()) {
            results.put("No Results", "No checks were selected.");
        }
        dispatcher.forward(req, res); // Forward request and response to the JSP page
    }

    // Method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Method to check if a number is perfect
    private boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    // Method to check if a number is Armstrong
    private boolean isArmstrong(int num) {
        int sum = 0, temp = num, remainder, n = 0;
        while (temp != 0) {
            temp /= 10;
            n++;
        }
        temp = num;
        while (temp != 0) {
            remainder = temp % 10;
            sum += Math.pow(remainder, n);
            temp /= 10;
        }
        return sum == num;
    }

    // Method to check if a number is strong
    private boolean isStrong(int num) {
        int sum = 0, temp = num, digit;
        while (temp != 0) {
            digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == num;
    }

    // Helper method for factorial calculation
    private int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check if a number is a spy number
    private boolean isSpy(int num) {
        int sum = 0, product = 1, temp = num, digit;
        while (temp != 0) {
            digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // Method to check if a number is a palindrome
    private boolean isPalindrome(int num) {
        int reversed = 0, original = num, remainder;
        while (num != 0) {
            remainder = num % 10;
            reversed = reversed * 10 + remainder;
            num /= 10;
        }
        return original == reversed;
    }
}
