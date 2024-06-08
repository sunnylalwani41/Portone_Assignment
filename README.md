## Portone Assignment
<img src="https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Fa69b1549-60af-4aa0-b3b7-a2ba8a181ce4%2Fffb8c6ad-7063-4c8f-bdd6-b74cfaa439cd%2FPortOne_%25E1%2584%258B%25E1%2585%25AF%25E1%2586%25AB%25E1%2584%2592%25E1%2585%25A7%25E1%2586%25BC_black.png&blockId=49a975bc-e740-4e40-84c5-3278afc93ead&width=256" alt="" style="margin: auto; display: block;">

## Stripe Payment Gateway Integration

 **REST API SERVICE**

The **Portone Assignment** is a REST API and it is integrate the Stripe Payment Gateway which allows to perform the **Create Payment Intent**, **Capture the Created Payment Intent**, **Create the Refund** and **Get All Payment Intent**.

The **Portone Assignment** REST API simplified Exception Handling for layman's easy understanding. 

The API's primary objective is to provide to the customer **with a seamless experience and user-friendly environment during online payment.**

The API's Services consist the following points with HTTP Methods:
|S.No. | End Point | HTTP Method |
|:-----:|:-------|:----------:|
| 1 | ```/api/v1/create_intent``` | POST |
| 2 | ```/api/v1/attach_payment_metho``` | POST |
| 3 | ```/api/v1/capture_intent/{id}``` | POST |
| 4 | ```/api/v1/create_refund/{id}``` | POST |
| 5 | ```/api/v1/get_intents``` | GET |

## Tech Stack

- JAVA
- SPRING
- SPRINGBOOT
- MAVEN
- SWAGGER UI

## Dependencies

- SPRING BOOT DEVTOOLS
- SPRING WEB
- LOMBOK
- SWAGGER UI

## Modules

- Payment Intent Module
- Capture Module
- Refund Module
- Exception Handler Module

## System Structure

The REST API allows a Customer to **Create Payment**, **Capture Payment** **Refund Payment** & **Get All Payment Information** through the **browser** with appropriate Http Methods.

## About
This assignment is for **portone.io**, This is an online accept the payment (payment gateway) Rest API. We built this Rest API assignment Within 2 days and Please [click here for Demo Video](https://drive.google.com/file/d/1h5YWO9Tjh-r-Aey1Fn6W5U5pkTKz143j/view?usp=sharing).

## Feature
- Restaurant
    - 
    - Signup
    - Login & Logout
    - View all Food
    - View all Orders of an Customer as order that Restaurant
    - Add New Food into Database
    - Remove Food from Database
    - Update Food in Database 
    - Update their Profile

- Customer
    -
    - Signup 
    - Login & Logout
    - Update all Personal Details 
    - View all Food .
    - Add Food to Cart
    - Update Food Quantity in Cart 
    - Delete Food from Cart
    - Empty Cart
    - Add Order
    - Cancel Order
    - View Orders

- Administrator
    -
    - Login
    - View Deleted Account Request
    - Delete Account as per Request

## Installation

- copy this https://github.com/sunnylalwani41/Your_Door_Food_REST_API.git
- Select path where you want to store the project in your pc
- open the corresponding file / folder with editor
- open terminal of your editor
- use  --> git clone (paste link) <-- 
- after project cloned to your folder
- go to YourDoorFoodApplication.java file inside com.masai folder
- run as Spring Boot

### Postman link of Stripe Payment Gateway Integration
click here to see in the [Postman](https://www.postman.com/material-geologist-27820143/workspace/stripe-payment-gateway).
