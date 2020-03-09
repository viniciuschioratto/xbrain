package com.xbrain.Xbrain.api.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xbrain.Xbrain.api.dto.PedidoDTO;
import com.xbrain.Xbrain.api.dto.ProdutosDTO;
import com.xbrain.Xbrain.model.entity.Pedido;
import com.xbrain.Xbrain.model.entity.Produto;
import com.xbrain.Xbrain.rabbitmq.OrderQueueSender;
import com.xbrain.Xbrain.service.PedidoService;
import com.xbrain.Xbrain.service.ProdutoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoResource {
	
	private PedidoService servicePedido;
	
	private ProdutoService serviceProduto;
	
	private OrderQueueSender rabbitmq;
	
	public PedidoResource(PedidoService servicePedido,ProdutoService serviceProduto,OrderQueueSender rabbitmq) {
		this.servicePedido = servicePedido;
		this.serviceProduto = serviceProduto;
		this.rabbitmq = rabbitmq;
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody PedidoDTO dto) {
		
		try {
			Pedido pedido = new Pedido();
			pedido.setValor(dto.getValor());
			pedido.setBairro(dto.getBairro());
			pedido.setCidade(dto.getCidade());
			pedido.setEstado(dto.getEstado());
			pedido.setNumero(dto.getNumero());
			pedido.setRua(dto.getRua());
			pedido = servicePedido.salvar(pedido);
			
			List<ProdutosDTO> produtos = dto.getId_produto();
			
			for(int n = 0; n < produtos.size() ; n++) {
				Produto produto = new Produto();
				produto.setId_product(produtos.get(n).getId());
				produto.setId_purchase(pedido.getId());
				
				produto = serviceProduto.salvar(produto);
			}
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(pedido);
			rabbitmq.send(json);
			
			return new ResponseEntity(pedido,HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
