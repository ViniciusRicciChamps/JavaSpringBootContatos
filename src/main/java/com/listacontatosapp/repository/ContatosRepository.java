package com.listacontatosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.listacontatosapp.models.Contatos;

public interface ContatosRepository extends CrudRepository<Contatos, Long>{

}
