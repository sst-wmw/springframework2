package service;

import java.util.ArrayList;

import domain.ItemPedido;

public class PedidoService {
	
	public static double getVlTotalPedido(ArrayList<ItemPedido> listItemPedido) {
		int size = listItemPedido.size();
		double vlTotal = 0;
		for (int i = 0; i < size; i++) {
			ItemPedido item = listItemPedido.get(i);
			vlTotal += item.getVlItem();
		}
		return vlTotal;
	}

}
