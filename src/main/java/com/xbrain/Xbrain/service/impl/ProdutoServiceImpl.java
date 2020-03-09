package com.xbrain.Xbrain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xbrain.Xbrain.model.entity.Produto;
import com.xbrain.Xbrain.model.repository.ProdutoRepository;
import com.xbrain.Xbrain.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private ProdutoRepository repository;
	
	public ProdutoServiceImpl(ProdutoRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional
	public Produto salvar(Produto produto) {
		return repository.save(produto);
	}

	@Override
	public Optional<Produto> obterId(Long id) {
		return repository.findById(id);
	}

}
