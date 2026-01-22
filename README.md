# 💰 Money Management System

A full-stack **Money Management System** designed to help users track income, expenses, categories, and financial summaries securely and efficiently.

This project is built using **Spring Boot (Backend)** and a **modern frontend** with secure authentication and role-based access.

---

## 🚀 Features

- User Registration & Login (JWT Authentication)
- Income Management
- Expense Management
- Category Management
- Dashboard with financial summary
- Email notifications (Brevo SMTP)
- Secure REST APIs
- Environment-based configuration (no secrets in repo)

---

## 🛠️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- Hibernate
- MySQL
- Maven

### Frontend
- JavaScript
- React (in `moneymanagerwebapp` folder)
- Tailwind CSS

### Tools
- Git & GitHub
- Postman
- Maven Wrapper

---

## 📂 Project Structure
Money_Management_System
│
├── moneymanager # Spring Boot backend
│ ├── src/main/java
│ ├── src/main/resources
│ └── pom.xml
│
├── moneymanagerwebapp # Frontend application
│
├── .gitignore
└── README.md



---

## ⚙️ Environment Configuration

Create a `.env` file **locally** (do NOT push to GitHub):

DB_USERNAME=Your username
DB_PASSWORD=Your Password

SMTP_API_KEY=your_brevo_api_key
MAIL_FROM=your_email@gmail.com

JWT_SECRET=your_jwt_secret

MONEY_MANAGER_FRONTEND_URL=http://localhost:3000
MONEY_MANAGER_BACKEND_URL=http://localhost:8080



---

## 🧪 How to Run Backend (Spring Boot)

```bash
cd moneymanager
./mvnw spring-boot:run

Backend will run on:
http://localhost:8080

🌐 How to Run Frontend-
cd moneymanagerwebapp
npm install
npm start

Frontend will run on:
http://localhost:3000

🔐 Security Notes

Secrets are not committed

.env, target/, .class, .DS_Store are ignored via .gitignore

GitHub Push Protection compliant

📌 Future Improvements

Charts & analytics

Budget planning

Export reports (PDF/Excel)

Cloud deployment (AWS / Docker)

👨‍💻 Author:
Saurabh Herekar
Java Full Stack Developer
GitHub: https://github.com/SaurabhHerekar








