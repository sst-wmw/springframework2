package service;

import dao.ItemPedidoDao;
import domain.Pedido;

public class ItemPedidoService {
	
	public void insereItensPedido(Pedido pedido) {
		ItemPedidoDao dbItemPedido = new ItemPedidoDao();
		dbItemPedido.executeInsertTransaction(pedido);
	}

}
