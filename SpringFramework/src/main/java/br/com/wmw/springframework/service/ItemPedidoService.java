package br.com.wmw.springframework.service;

import java.sql.SQLException;
import java.util.List;

import br.com.wmw.springframework.dao.ItemPedidoDao;
import br.com.wmw.springframework.domain.ItemPedido;
import br.com.wmw.springframework.domain.Pedido;

public class ItemPedidoService {

	private ItemPedidoDao dao;

	public void setDao(ItemPedidoDao itemPedidoDao) {
		this.dao = itemPedidoDao;
	}

	public void insert(final ItemPedido itemPedido) throws SQLException {
		this.dao.insert(itemPedido);
	}

	public void insert(final List<ItemPedido> items) throws SQLException {
		this.dao.insert(items);
	}

	public List<ItemPedido> findAllByExamples(final ItemPedido itemPedido) throws SQLException {
		return this.dao.findAllByExamples(itemPedido);
	}

	public List<ItemPedido> findAllByPedido(final Pedido pedido) throws SQLException {
		ItemPedido item = new ItemPedido();
		item.setCdPedido(pedido.getCdPedido());
		return this.dao.findAllByExamples(item);
	}

}
