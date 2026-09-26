# 📝 ExamPortal (QuizPortal)

A full-stack **online examination system** built with **Spring Boot**, where organisers can create and manage exams, upload candidates via CSV, and candidates can log in with a unique exam code to attempt the exam and instantly view their results.

---

## 📌 What is this project?

**ExamPortal** is a web-based exam/quiz management platform designed for two types of users:

- 🧑‍💼 **Organisers** — register, log in, and create/manage exams, questions, and candidates.
- 🧑‍🎓 **Users/Candidates** — join an exam using a unique **exam code**, read the instructions, attempt the exam, and view their result.

It's a classic **CRUD + authentication + exam-taking workflow** app, great for institutes, trainers, or companies who want to conduct online tests without a third-party tool.

---

## ✨ Features / Functionality

### 🧑‍💼 Organiser Side
- 🔐 Organiser **registration & login** (secured with Spring Security + BCrypt password hashing)
- 📊 **Dashboard** (built with AdminLTE) to manage everything in one place
- 🗂️ **Create, edit, view exams** — set title, description, instructions, start date, marks per question, duration, etc.
- ❓ **Add / edit / delete questions** with multiple options for each exam
- 👥 **Add candidates manually** or **bulk upload via CSV** (Name + Email)
- 📧 **Email exam credentials** to candidates automatically (SMTP mail integration)
- 📈 **View results** of all candidates who attempted an exam

### 🧑‍🎓 Candidate (User) Side
- 🔑 Login to a specific exam using a unique **exam code**
- 📋 View **exam instructions** before starting
- 🧭 Attempt the exam **question-by-question** with navigation
- ✅ Submit answers and auto-save progress
- 🏁 View **final result/score** immediately after submission
- 🚪 Logout securely once done

### ⚙️ Other Highlights
- 🔒 Role-based access — organiser routes are protected, only `/organiser/register` and public pages are open
- 🗃️ **Server-side sessions** stored in the database (Spring Session + JDBC) instead of memory
- 📎 File upload support for CSV candidate lists (max size configured)
- 🎨 Clean, responsive UI using **Bootstrap** & **AdminLTE** admin theme with **Thymeleaf** templating
- ⚠️ Custom **404 / 500** error pages

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| **Language** | ☕ Java 17 |
| **Framework** | 🍃 Spring Boot 2.7.14 |
| **Web Layer** | Spring MVC (`spring-boot-starter-web`) |
| **Templating** | 🌿 Thymeleaf (+ Spring Security integration) |
| **Security** | 🔐 Spring Security + BCrypt password encoding |
| **Data Access** | 🗄️ Spring Data JPA / Hibernate |
| **Database** | 🐬 MySQL |
| **Session Management** | Spring Session (JDBC-backed) |
| **Mail** | 📧 Spring Boot Starter Mail (SMTP, e.g. Mailtrap) |
| **File Parsing** | Apache Commons CSV |
| **Frontend/UI** | Bootstrap 4, AdminLTE 3 (via WebJars) |
| **Build Tool** | 🏗️ Maven (`mvnw` wrapper included) |
| **Testing** | JUnit + Spring Boot Test + Spring Security Test |

### 📁 Project Structure
```
ExamPortal/
├── src/main/java/com/examportal/
│   ├── Controller/      # AppController, ExamController, OrganiserController, QuestionController, UserController
│   ├── Model/           # Exam, Question, Option, Answer, User, UserAnswer, UserExam, Organiser
│   ├── Repository/      # Spring Data JPA repositories for each entity
│   ├── Utils/           # CSVHelper, RandomString, ResponseMessage
│   ├── config/          # WebSecurityConfig (Spring Security rules)
│   └── QuizPortalApplication.java   # Main entry point
├── src/main/resources/
│   ├── templates/       # Thymeleaf HTML views (organiser + user pages)
│   └── application.properties
└── pom.xml
```

---

## 🚀 How to Run

### ✅ Prerequisites
Make sure you have the following installed:
- ☕ **Java 17 (JDK)**
- 🐬 **MySQL Server** (running locally)
- 🏗️ Maven (optional — the project ships with the `mvnw` wrapper, so a local Maven install isn't required)

### 1️⃣ Clone the repository
```bash
git clone https://github.com/ParasJain12/ExamPortal.git
cd ExamPortal
```

### 2️⃣ Create the MySQL database
```sql
CREATE DATABASE QuizPortal;
```
> Tables are auto-created/updated on startup via `spring.jpa.hibernate.ddl-auto=update`, so you don't need to write schema SQL manually.

### 3️⃣ Configure database & mail credentials
Open `src/main/resources/application.properties` and update:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/QuizPortal
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.mail.host=smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=YOUR_MAIL_USERNAME
spring.mail.password=YOUR_MAIL_PASSWORD
```
> ⚠️ **Security tip:** The repo currently has sample DB/mail credentials committed in `application.properties`. Replace them with your own, and consider moving secrets to environment variables (`${DB_PASSWORD}` style) or a `.gitignore`'d config file before pushing further changes.

### 4️⃣ Build & run the application

Using the Maven wrapper (recommended, no local Maven needed):
```bash
# macOS/Linux
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

Or build a JAR and run it:
```bash
./mvnw clean package
java -jar target/QuizPortal-0.0.1-SNAPSHOT.jar
```

### 5️⃣ Open the app
Visit **http://localhost:8080** in your browser. 🎉

- Organiser registration: `http://localhost:8080/organiser/register`
- Organiser login: `http://localhost:8080/organiser/login`
- Candidates log in with an **exam code** shared by the organiser at: `http://localhost:8080/{examCode}/login`

---
## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

## 📬 Contact

For any queries, reach out at **parasjain8103@gmail.com** or use the [Contact Us](https://parasjain12.github.io/) page on the website.

---

<p align="center">Made with ❤️ by Paras Jain</p>
