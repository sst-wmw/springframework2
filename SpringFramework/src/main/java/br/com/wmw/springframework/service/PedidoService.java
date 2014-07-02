package br.com.wmw.springframework.service;

import java.sql.SQLException;

import br.com.wmw.springframework.dao.PedidoDao;
import br.com.wmw.springframework.domain.Pedido;

public class PedidoService {

	private PedidoDao dao;
	private ItemPedidoService itemService;

	public void setDao(PedidoDao pedidoDao) {
		this.dao = pedidoDao;
	}

	public void setItemService(ItemPedidoService itemService) {
		this.itemService = itemService;
	}

	public void insert(final Pedido pedido) throws SQLException {
		this.dao.insert(pedido);
		itemService.insert(pedido.getItems());
	}

	public Pedido findByPrimaryKey(final Pedido filter) throws SQLException {
		Pedido pedido = this.dao.findByPrimaryKey(filter);
		if (pedido != null) {
			pedido.setItems(itemService.findAllByPedido(pedido));
		}
		return pedido;
	}

}
