package com.example.Lecture.repository;

import com.example.Lecture.entity.ClickedNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickedNewsRepository extends JpaRepository<ClickedNews, Long> {
    public ClickedNews findByClickedNewsNo(String clickedNewsNo);
}
