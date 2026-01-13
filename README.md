📝 Task Manager Application – Spring Boot REST API
📌 Project Overview

The Task Manager Application is a backend RESTful API built using Spring Boot that helps manage projects, users, and tasks efficiently.
It supports task assignment, email notifications, file attachments, and automated scheduling, making it suitable for real-world team or organizational use cases.

This project demonstrates clean layered architecture, real-time automation, and enterprise-level backend practices.

🚀 Key Features
👤 User Management

Create and manage users

Assign tasks to users

Fetch tasks assigned to a specific user

📁 Project Management

Create projects

Associate tasks with projects

✅ Task Management

Create, update, delete tasks

Assign tasks to users

Track task status (PENDING / COMPLETED)

Fetch pending tasks

Get tasks by user or project

📎 File Attachment Module

Upload files to tasks

Validate file size and file type

Fetch all files attached to a task

Delete attached files

Supports PDF, images, and document formats

📧 Email Notification System

Send email when a task is assigned to a user

Send reminder emails for pending tasks

Integrated using JavaMailSender

Gmail App Password–based authentication

⏰ Scheduler Automation

Daily scheduled job using @Scheduled

Automatically sends reminder emails for pending tasks

Runs at a fixed time every day (cron-based)

⚠ Exception Handling

Centralized exception handling

Meaningful HTTP status responses

Proper validation and error messages

📦 DTO Usage

Clean separation between Entity and API payloads

Improves security and flexibility

🛠 Technologies Used

Java 17

Spring Boot

Spring Data JPA

Hibernate

Spring Scheduler

Java Mail API

MySQL

REST APIs

Maven

🧱 Architecture Overview
Controller Layer  →  Service Layer  →  Repository Layer  →  Database
                       ↓
                  Email Service
                       ↓
                  Scheduler


Controllers handle HTTP requests

Services contain business logic

Repositories interact with the database

Scheduler automates background jobs

Email service handles notifications

📌 Important Concepts Implemented

Layered Architecture (Controller–Service–Repository)

Entity Relationships (@ManyToOne, @OneToMany)

Multipart File Upload

Cron-based Scheduling

Stream API usage

Optional handling

RESTful API design

Clean code practices

📂 Use Cases

Assign tasks to team members

Upload task-related documents

Automatically remind users about pending tasks

Track project progress

Centralized task and file management

🎯 Learning Outcomes

This project helped me gain hands-on experience with:

Building real-world Spring Boot applications

Email integration and automation

Scheduler-based background jobs

File handling APIs

Designing scalable backend systems

🔮 Future Enhancements

JWT Authentication & Role-Based Access

File download support

Swagger/OpenAPI documentation

Pagination and sorting

Cloud file storage (AWS S3)

👨‍💻 Author

Harikrishna E
Java Backend Developer | Spring Boot Enthusiast
