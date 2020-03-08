package com.xbrain.Xbrain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xbrain.Xbrain.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
