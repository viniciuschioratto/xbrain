package com.xbrain.Xbrain.service;

import java.util.Optional;

import com.xbrain.Xbrain.model.entity.Pedido;

public interface PedidoService {

	Pedido salvar(Pedido pedido);
	
	Optional<Pedido> buscaId(Long id);
}
