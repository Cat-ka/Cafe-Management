package com.cafe.dao_repository;


import com.cafe.POJO.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {


    List<Category> getAllCategory();

}
