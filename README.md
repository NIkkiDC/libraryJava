# 👩🏿‍🏫 Famous Black Authors 

<br>

## 🧾 Table Of Contents 
* Project Description 
* Tools & Technoilogies 
* Kanban Project Plan <sub> {Project Aproach} </sub>
* User Stories 
* ERD Diagram
* Endpoint Mappings (controller/service controller) (delete this) this is to help u recall)
* Kanban Project Plan
* Hurdles
* Installation Instructions 
* Credits 


## 📇 Project Description

This project was created to find famous Black authors that often go un-noticed. In honor of Juneteenth you don’t have to google Black authors to support because they will all be implemented here. This project was created with a monolithic approach utilizing spring boot and its modules. 
<br>

## 🛠️ Tools & Tech 
* JAVA
* GITHUB
* POSTMAN
* SPRINGBOOT
* APPLE NOTES
* INTELLIJ
* ERD Tool
* H2
* ERD Tool

<br>

## 📊 Kanban Project Plan 

<img width="1449" alt="Screenshot 2023-05-11 at 11 37 03 AM" src="https://github.com/NIkkiDC/libraryJava/assets/97572760/b910412c-d7a9-42ef-a17d-8dfcc2e157e1">

<br>

## 📝 User Stories 

As a user I should be able to create an Author in the database.

As a user I should be able to look up a single author.

As a user I should be able to update a single author.

As a user I should be able to delete a single author.

As a user I should be able to create a book for a single author.

As a user I should be able to update a book that belongs to a single author.

As a user I should be able to delete a book that belongs to a single author.

As a user I should be able to delete a single author.

As a user, Im able to get a list of authors from my database so I can find different books from the authors.

As a user I should not be allowed to make duplicate entries of authors. If I should make a duplicate entry of an author an error should immediately come across the screen, so I don’t input that duplicate. 

<br>

## 🗺️ Endpoint Mappings


| Request Type | URL                   | Functionality                         | Access | 
|--------------|-----------------------|---------------------------------------|--------|
| POST         | /api/author/          | Create author                         | Public |
| GET          | /api/author/1/        | Get single author                     | Public |
| PUT          | /api/author/1/        | Update single author                  | Public |
| DELETE       | /api/author/1/        | Delete single author                  | Public |
| POST         | /api/author/1/book/   | Creating a book for a single author   | Public |
| GET          | /api/author/1/book/1/ | Get a book belongs a single author    | Public |
| PUT          | /api/author/1/book/1/ | Update a book belongs a single author | Public |
| DELETE       | /api/author/1/book/1/ | Delete a book belongs a single author | Public |


## 📰 ERD Diagram

<img width="806" alt="Screenshot 2023-05-12 at 4 13 08 PM" src="https://github.com/NIkkiDC/libraryJava/assets/97572760/bf247c17-4b1d-4961-9187-7a56dce4dd36">


<br>

## 📚 Installation Instructions 

Copy and paste the code below into your pom.xml file. Once copied right mouse click on your pom.xml file and select Maven and then Reload project. This will install the dependecnies.

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
		
				<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		
				<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		
				<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
 
 <br>

down below is the test of obtaining all authors. Their first and last name is illustrated, a discription about them, and an ID number 

<img width="1047" alt="Screenshot 2023-05-14 at 11 08 33 AM" src="https://github.com/NIkkiDC/libraryJava/assets/97572760/63f284f8-27e5-423f-9d77-ccf0442507f1">



<br>

## 🔖 Credits 
Thank you so much to Wanda, she helped me understand what I was doing better, and she helped me refactor my project where it needed refactoring. Wanda also was sure to explain her thought process on any refactoring she wanted me to implment. 
Thank you to group RC {Rachel & Clair} They were the support system that I needed during this project.

<br>

### smaller but bold 

This site was built using [GitHub Pages](https://pages.github.com/).
<sub>Created by Dominique Collins </sub>
