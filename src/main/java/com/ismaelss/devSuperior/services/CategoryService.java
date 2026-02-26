package com.ismaelss.devSuperior.services;

import com.ismaelss.devSuperior.dto.CategoryDTO;
import com.ismaelss.devSuperior.entities.Category;
import com.ismaelss.devSuperior.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findALl() {
        List<Category> list = repository.findAll();

        return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
        //TODO: testa velocidade comparada com conversão atravez de um for
    }
}
