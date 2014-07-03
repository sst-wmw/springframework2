package service;

import java.util.ArrayList;

import dao.PedidoDao;
import domain.ItemPedido;
import domain.Pedido;

public class PedidoService {
	
	public double getVlTotalPedido(ArrayList<ItemPedido> listItemPedido) {
		int size = listItemPedido.size();
		double vlTotal = 0;
		for (int i = 0; i < size; i++) {
			ItemPedido item = listItemPedido.get(i);
			vlTotal += item.getVlItem();
		}
		return vlTotal;
	}
	
	public void inserePedido(Pedido pedido) {
		PedidoDao dbPedido = new PedidoDao();
		dbPedido.executeInsertTransaction(pedido);
		//--
		ItemPedidoService itemPedidoService = new ItemPedidoService();
		itemPedidoService.insereItensPedido(pedido);
	}

}
