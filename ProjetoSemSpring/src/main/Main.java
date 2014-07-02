package main;

import java.sql.SQLException;
import java.util.ArrayList;

import service.PedidoService;
import domain.ItemPedido;
import domain.Pedido;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		Pedido pedido = new Pedido();
		ItemPedido itemPedido = new ItemPedido();
		ItemPedido itemPedido2 = new ItemPedido();
		ArrayList<ItemPedido> listItemPedido = new ArrayList<ItemPedido>();
		// descomentar linha abaixo para gerar erro que dispara o rollback.
//		pedido.setCdPedido(8);
		itemPedido.setVlItem(25);
		itemPedido2.setVlItem(25);
		listItemPedido.add(itemPedido);
		listItemPedido.add(itemPedido2);
		//--
		pedido.setListItemPedido(listItemPedido);
		pedido.setVlPedido(PedidoService.getVlTotalPedido(listItemPedido));
		//--
		PedidoService.inserePedido(pedido);
    }
	
}
