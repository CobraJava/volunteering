package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Jacket;

import java.util.List;

public interface BaseService<TEntity> {

    TEntity getById(Long id);

    TEntity save(TEntity entity);

    TEntity update(Long id, TEntity entity);

    void delete(Long id);

    List<TEntity> getAll();

}
