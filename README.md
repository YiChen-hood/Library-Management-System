# Library-Management-System

1.1 Introduction

This is a project - library management system. Knowledge include: object-oriented thought, layered thought, interface, exception, sets, data processing, Streams, IO stream, reflection, Javafx, CSS. 

How to use this system: you need to sign up an account first, then login.

1.2 Environment

Developed tool: IntelliJ IDEA

JDK version: 8

Project encoding: UTF-8 / GBK

1.3 Technology

In addition to JavaSE, it also uses third-party technologies, including

- Jfoenix: provides more beautiful UI space
- Dashboardfx: combine some beautiful UI spaces to build a dashboard

1.4 Code files

- Bean: entity package
- global: global class
- Media.img: images
- Module: interface class
- Service: service class 
- Theme: class that beautified the interface 
- APP: main class

Each interface has a corresponding fxml file, which controls its interface effect.

1.5 Code layers

- controller (request-processing layer): responsible for interactive processing with interface data
- service (Business-processing layer): Responsible for processing with business logic
- DAO (Data persistence layer): Responsible for data persistence operation. (Data access object)
