package com.service.springrest.service;

import com.service.springrest.service.dto.ClienteDTO;

import java.util.List;

public interface CrudService <D, E>{

    D save (D dto);

    List<D> getAll();

    D getById(E id);

    void delete(E id);
}
