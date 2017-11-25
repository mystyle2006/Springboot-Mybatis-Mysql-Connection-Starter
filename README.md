# WHAT YOU WILL NEED
* Springboot 1.4.4
* JDK 1.8
* Eclipse or other IDE
* Maven 3 or later

# Project Structure
![Alt text](https://user-images.githubusercontent.com/18185890/33229886-86aa27e4-d21b-11e7-9796-5719c976a5f2.PNG)

# HOW TO RUN
If Maven is not installed on your system,
Click **Run** -> **Debug configurations...** -> **Maven Build** --> Fill the blank like the below image.

![Alt text](https://user-images.githubusercontent.com/18185890/33229856-ebad03f6-d21a-11e7-8a16-4b2907c434ba.PNG)

If it is installed,
"**MVN CLEAN PACKAGE**" and "**MVN SPRING-BOOT:RUN**"

# STEPS
* Set up pom.xml with dependencies for our project like mybatis, mysql
* Set up application.properties for the database connection source
* Create a database
* Create SqlSessionFactory bean for the connection
* Create VO(Value Object) for our board
* Create Mapper interface for our board
* Create Mapper for our board

## Set up pom.xml with dependencies for our project like mybatis, mysql
We need to include those dependenceis below for our project
* ***spring-boot-starter-actuator*** to manage our application
* ***spring-boot-starter-web*** to set up a basic springboot
* ***spring-boot-devtools to*** update our application automatically
* ***spring-boot-starter-test*** to test our application by jUnit
* ***spring-boot-starter-jdbc*** to connect Mysql through JAVA
* ***mysql-connector-java*** to connect Mysql through JAVA
* ***mybatis-spring*** to use mybatis
* ***mybatis*** to use mybatis

**Full Source Code**
~~~
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.restful</groupId>
	<artifactId>board-services</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>

	<name>board-services</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.4.4.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<!-- ::START_BASIC SPRINGBOOT -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- ::END_BASIC SPRINGBOOT -->
		
		<!-- ::START_JDBC & MYSQL -->
		<dependency>
		   <groupId>org.springframework.boot</groupId>
		   <artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<dependency>
		   <groupId>mysql</groupId>
		   <artifactId>mysql-connector-java</artifactId>
		   <scope>runtime</scope>
		</dependency>
		<!-- ::END_JDBC & MYSQL -->
		
		<!-- ::START_MYBATIS -->
		<dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.2.4</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.3.1</version>
        </dependency>
		<!-- ::END_MYBATIS -->
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>


</project>
~~~
