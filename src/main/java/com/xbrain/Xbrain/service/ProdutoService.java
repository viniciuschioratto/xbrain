package com.xbrain.Xbrain.service;

import java.util.List;
import java.util.Optional;

import com.xbrain.Xbrain.model.entity.Produto;

public interface ProdutoService {
	
	Produto salvar(Produto produto);
	
	Optional<Produto> obterId(Long id);

}
