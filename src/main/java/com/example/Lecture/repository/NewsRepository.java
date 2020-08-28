package com.example.Lecture.repository;

import com.example.Lecture.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    public News findByNewsNo(String newsNo);
}
