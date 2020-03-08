package com.xbrain.Xbrain.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xbrain.Xbrain.model.entity.Pedido;
import com.xbrain.Xbrain.model.repository.PedidoRepository;
import com.xbrain.Xbrain.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	private PedidoRepository repository;
	
	public PedidoServiceImpl(PedidoRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	@Transactional
	public Pedido salvar(Pedido pedido) {
		//Irei salvar os dados do pedido e logo em seguida os produtos deste pedido
		return repository.save(pedido);
	}

	@Override
	public Optional<Pedido> buscaId(Long id) {
		return repository.findById(id);
	}

}
