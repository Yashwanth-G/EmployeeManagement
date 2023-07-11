# Employee Management

This is a full-stack java application that mainly built on Java - backend & React - frontend

## Architecture

This full-stack application follows Client-Server model. Both front-end and back-end are loosely coupled. Backend application will expose the REST APIs that are developed using Java, Spring Boot and the front end applciation will consume those REST APIs that is built using React. 

Backend Applciation is built in 3 layers - Model, Service and DAO layers. 
Frontend Application consists of Router, Components and Services. To make REST API call to backend applciation this project uses Axios HTTP Library as React alone can not make HTTP calls to Backend application. 

Payload used is JSON i.e., the data exchanged between Frontend and backend applications will be in JSON format.

## Technologies Used
- Spring Boot 3
- Spring 6
- Spring Data JPA (Hibernate 6)
- MySQL Database
- Intellij IDEA
- Maven
- Postman Client
- React JS 18+
- Vite JS
- BootStrap CSS
- JavaScript
- NPM
- Visual Studio Code IDE
- Axios
  
## REST APIs for Employee Management Module
- Add Employee
- Get Employee
- Get All Employees
- Update Employee
- Delete Employee

## Front End UI for Employee Management Module
- Add New Department
- List the Departments
- Update existing Departments
- Delete existing Department
- Add Employee to a particular Department
