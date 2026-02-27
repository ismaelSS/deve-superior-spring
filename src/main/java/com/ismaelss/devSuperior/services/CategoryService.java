package com.ismaelss.devSuperior.services;

import com.ismaelss.devSuperior.dto.CategoryDTO;
import com.ismaelss.devSuperior.entities.Category;
import com.ismaelss.devSuperior.repositories.CategoryRepository;
import com.ismaelss.devSuperior.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    @Transactional(readOnly = true)
    public CategoryDTO findById(long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Category not found."));
        return new CategoryDTO(entity);
    }
}
