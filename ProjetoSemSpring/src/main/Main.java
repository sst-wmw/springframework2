package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.PedidoService;
import db.DbConnection;
import domain.ItemPedido;
import domain.Pedido;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Pedido pedido = new Pedido();
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setVlItem(15);
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido2.setVlItem(15);
		ArrayList<ItemPedido> listItemPedido = new ArrayList<ItemPedido>();
		listItemPedido.add(itemPedido);
		listItemPedido.add(itemPedido2);
		pedido.setListItemPedido(listItemPedido);
		pedido.setVlPedido(PedidoService.getVlTotalPedido(listItemPedido));
		inserePedidosEItens(pedido, listItemPedido);
//		listaPedidosEItens();
    }

	@SuppressWarnings("unused")
	private static void listaPedidosEItens() throws SQLException {
		ResultSet rs = DbConnection.executeSql("SELECT * FROM PEDIDO");
		while (rs.next()) {
			// Imprime os pedidos
			System.out.println(
					"Pedido: " + rs.getInt("CDPEDIDO") +
					" Valor do Pedido: R$" + rs.getDouble("VLPEDIDO")
			);
			// Busca os itens do pedido e imprime
			ResultSet rs2 = DbConnection.executeSql("SELECT * FROM ITEMPEDIDO WHERE CDPEDIDO = " + rs.getDouble("CDPEDIDO"));
			while (rs2.next()) {
				System.out.println(
						"Pedido: " + rs2.getInt("CDPEDIDO") +
						" ItemPedido: " + rs2.getInt("CDITEMPEDIDO") +
						" Produto: " + rs2.getInt("CDITEMPEDIDO") +
						" Valor do Item: R$" + rs2.getDouble("VLITEM")
				);
			}
			DbConnection.close(rs2);
		}
		DbConnection.close(rs);
		DbConnection.close();
	}
	
	private static void inserePedidosEItens(Pedido pedido, ArrayList<ItemPedido> listItemPedido) {
			
	}

}
