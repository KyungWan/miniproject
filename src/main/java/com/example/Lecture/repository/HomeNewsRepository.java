package com.example.Lecture.repository;

import com.example.Lecture.entity.HomeNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeNewsRepository extends JpaRepository<HomeNews, Long> {
}
