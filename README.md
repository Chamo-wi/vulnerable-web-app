# 🚀 VulnSpring: OWASP Training Lab

VulnSpring is a deliberately vulnerable web application built using Java and Spring Boot to demonstrate common OWASP web security vulnerabilities.

This project was developed as part of a cybersecurity learning journey to understand how real-world attacks work and how insecure coding practices can lead to serious security issues.

---

## 🎯 Objective

To design and implement a vulnerable web application, perform manual penetration testing on it, and gain hands-on experience in identifying and understanding common web vulnerabilities.

---

## ⚙️ Core Features

- User Registration & Login
- Public Comment System
- Admin Panel
- File Upload Functionality
- Basic Session Handling

---

## 🚨 Implemented Vulnerabilities

### SQL Injection
The login functionality is intentionally vulnerable to SQL Injection, allowing authentication bypass using crafted inputs.

### Stored Cross-Site Scripting (XSS)
The comment section stores user input without proper sanitization, allowing malicious scripts to execute in the browser.

### Broken Authentication / Authorization
The admin panel can be accessed directly without proper access control, demonstrating weak authorization.

### Unrestricted File Upload
The file upload feature does not validate file types, allowing potentially harmful files to be uploaded.

---

## 🧪 Testing Approach

The application was tested using manual penetration testing techniques such as:

- Injecting SQL payloads into login fields  
- Testing XSS payloads in the comment section  
- Accessing restricted endpoints directly  
- Uploading files without validation  

---

## 🛠️ Tech Stack

- Java  
- Spring Boot  
- Maven  
- Thymeleaf (template engine)  
- Git & GitHub  

---

## ▶️ How to Run

1. Clone the repository:


git clone https://github.com/Chamo-wi/vulnerable-web-app.git


2. Navigate into the project:


cd vulnerable-web-app


3. Run the application:


./mvnw spring-boot:run


For Windows:


mvnw.cmd spring-boot:run


4. Open in your browser:


http://localhost:8080


---

## 📸 Demonstration


<img width="1853" height="1010" alt="Screenshot from 2026-04-04 12-45-16" src="https://github.com/user-attachments/assets/e8531e1c-42c1-4886-bba8-fee9912bc45a" />

### 🔥 Stored XSS Vulnerability

The application was tested using the following payload:

<script>alert('XSS')</script>

When this input was submitted through the comment section, it triggered a browser alert, demonstrating a Stored Cross-Site Scripting (XSS) vulnerability.

![XSS Demo](screenshots/xss-demo.png)

---

## ⚠️ Disclaimer

This project is intentionally vulnerable and created strictly for **educational purposes only**.

Do NOT deploy this application in a production environment.  
Do NOT use these techniques on systems without proper authorization.

---

## 💡 Learning Outcomes

- Understanding of OWASP Top vulnerabilities  
- Hands-on experience with exploiting web vulnerabilities  
- Awareness of insecure coding practices  
- Importance of input validation and access control  
- Experience using GitHub for version control  

---

## 🔗 Repository

https://github.com/Chamo-wi/vulnerable-web-app





## 🛡️ How to Fix These Vulnerabilities

### 1. SQL Injection Fix
- Use **prepared statements / parameterized queries**
- Avoid directly concatenating user input into SQL queries
- Use ORM frameworks like JPA or Hibernate

Example approach:
- Replace raw queries with parameter binding

---

### 2. Cross-Site Scripting (XSS) Fix
- Sanitize and validate all user inputs
- Escape output before rendering in the browser

In Thymeleaf:
- Use `th:text` instead of `th:utext` to prevent script execution

---

### 3. Broken Authentication / Authorization Fix
- Implement proper role-based access control (RBAC)
- Restrict access to admin endpoints using Spring Security
- Validate user sessions before granting access

Example:
- Protect `/admin` routes with authentication checks

---

### 4. Unrestricted File Upload Fix
- Validate file types and extensions
- Restrict allowed file formats (e.g., images only)
- Rename uploaded files and store them securely
- Scan files for malicious content if possible

---

## 🔐 Secure Coding Practices

- Always validate and sanitize user inputs  
- Use proper authentication and authorization mechanisms  
- Avoid exposing internal errors to users  
- Follow OWASP Top 10 guidelines during development  
