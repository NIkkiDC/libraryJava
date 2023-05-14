# 👩🏿‍🏫Famous Black Authors 

<br>

## 🧾 Table Of Contents 
* Project Description 
* Tools & Technoilogies 
* Project Aproach 
* ERD Diagram
* Endpoint Mappings (controller/service controller) (delete this) this is to help u recall)
* Kanban Project Plan
* Hurdles
* Installation Instructions 
* Credits 


## 📇Project Description

This project was created to find famous Black authors that often go un-noticed. In honor of Juneteenth you don’t have to google Black authors to support because they will all be implemented here. This project was created with a monolithic approach utilizing spring boot and its modules. 
<br>

## 🛠️Tools & Tech 
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

## 📑Project Approach 
project approach can be the user stories 
blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blahblah blah blah blah blah blah blah blah blah blah blah blahblah blah blah blah blah blah blah blah blah blah blah blahblah blah blah blah blah blah blah blah blah blah blah blahblah blah blah blah blah blah blah blah blah blah blah blah

USER STORIES 
blah blah blah blah blah blah blah blah blah blah blah blah
blah blah blah blah blah blah blah blah blah blah blah blah
blah blah blah blah blah blah blah blah blah blah blah blah

## ERD Diagram

<img width="806" alt="Screenshot 2023-05-12 at 4 13 08 PM" src="https://github.com/NIkkiDC/libraryJava/assets/97572760/bf247c17-4b1d-4961-9187-7a56dce4dd36">

<br>

## Endpoint Mappings


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


Photo of POST Authors (adding a book with book info, that was written by Toni Morission
<img width="829" alt="Screenshot 2023-05-14 at 9 49 56 AM" src="https://github.com/NIkkiDC/libraryJava/assets/97572760/04c860cf-1a95-46db-b601-d643d301520e">
 

Photo of book list updated bc you created a new book in the data base
<img width="839" alt="Screenshot 2023-05-14 at 9 51 17 AM" src="https://github.com/NIkkiDC/libraryJava/assets/97572760/0745d81e-abb4-43db-a921-fc40fded43db">


Photo of GET all books 
<img width="850" alt="Screenshot 2023-05-14 at 9 16 11 AM" src="https://github.com/NIkkiDC/libraryJava/assets/97572760/62c978af-502f-484d-af82-987ec0ea9fed">


<br>

## Kanban Project Plan 

<img width="1449" alt="Screenshot 2023-05-11 at 11 37 03 AM" src="https://github.com/NIkkiDC/libraryJava/assets/97572760/b910412c-d7a9-42ef-a17d-8dfcc2e157e1">

<br>

## Installation Instructions 

<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.7.8</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.library</groupId>
	<artifactId>demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>Library Java Project </name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
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
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
 
 <br>

down below is the test of obtaining all authors. Their first and last name is illustrated, a discription about them, and an ID number 

<img width="1080" alt="Screenshot 2023-05-09 at 8 36 23 PM" src="https://github.com/NIkkiDC/libraryJava/assets/97572760/22ca1a0f-6428-4f9a-8787-4df229f418c8">

<br>

## Credits 
Thank you so much to Wanda, she helped me understand what I was doing better, and she helped me refactor my project where it needed refactoring. Wanda also was sure to explain her thought process on any refactoring she wanted me to implment. 
Thank you to group RC {Rachel & Clair} They were the support system that I needed during this project.

<br>

### smaller but bold 

This site was built using [GitHub Pages](https://pages.github.com/).
<sub>Created by Dominique Collins </sub>
