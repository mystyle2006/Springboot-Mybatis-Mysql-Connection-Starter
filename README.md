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

## Set up application.properties for the database connection source
To use mysql, we need to set up properties at application.properties

~~~
##Server
server.port = 8181 //Eclipse uses 8080 internally by default
##Database
spring.datasource.driver-class-name= com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/springboot?useSSL=false
spring.datasource.username=inho
spring.datasource.password=1209123
~~~

## Create a database
First, you need to install [Mysql](https://dev.mysql.com/downloads/installer/) and create the table like below.

![Alt text](https://user-images.githubusercontent.com/18185890/33230021-563aa662-d21e-11e7-954b-befce0632dc9.PNG)

## Create SqlSessionFactory bean for the connection
Go to **src/main/java** and put the below code into our **BoardServicesApplication.java**

~~~
@Bean
public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	sessionFactory.setDataSource(dataSource); //db connection

	//Get mapper resources
	Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");

	sessionFactory.setMapperLocations(res);

	return sessionFactory.getObject();
}
~~~

## Create VO(Value Object) for our board
In **sec/main/java**, create the package like **com.restful.domain** and put the below code into it.
~~~
package com.restful.domain;

import java.sql.Timestamp;

public class BoardVO {
	private int id;
	private String name;
	private String title;
	private String content;
	private Timestamp date;
	
	public BoardVO(){
		
	}

	public BoardVO(int id, String name, String title, String content, Timestamp date) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + name + title + content + date;
	}
}
~~~

## Create Mapper interface for our board
In **src/main/java**, create the package like **com.restful.mapper** and put the code into it

~~~
package com.restful.mapper;

import java.util.ArrayList;

import com.restful.domain.BoardVO;

public interface BoardMapper {

	public ArrayList<BoardVO> boardSelect() throws Exception;
	
}
~~~

## Create Mapper for our board
In **src/main/resources**, create the folder named **mappers** and **boardMapper.xml** in it.

~~~
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.restful.mapper.BoardMapper">
	<select id="boardSelect" resultType="com.restful.domain.BoardVO">
		select * from board
	</select>
</mapper>
~~~

# Summary
