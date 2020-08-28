package com.example.Lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LectureApplication {
	// SpringApplication.run 하면
	// 웹 서버가 구동된다 - 서비스 번호: 8080
	public static void main(String[] args) {
		SpringApplication.run(LectureApplication.class, args);
	}
}
