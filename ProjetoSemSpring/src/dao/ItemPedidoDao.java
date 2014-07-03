package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import domain.ItemPedido;
import domain.Pedido;

public class ItemPedidoDao extends BaseDao {
	
	@Override
	public void beforeInsert() throws SQLException {
		multiTransacaoIniciada = false;
		super.beforeInsert();
	}
	
	@Override
	public void doInsert(Object obj) {
		Pedido pedido = (Pedido) obj;
		ArrayList<ItemPedido> listItemPedido = pedido.getListItemPedido();
		int size = listItemPedido.size();
		for (int i = 0; i < size; i++) {
			ItemPedido itemPedido = listItemPedido.get(i);
			BaseDao.executeSql("INSERT INTO ITEMPEDIDO VALUES (" + itemPedido.getCdItemPedido() + ", " + pedido.getCdPedido() + ", " + itemPedido.getVlItem() + ")");
		}
		super.doInsert(obj);
	}
	
	@Override
	public void afterInsert() throws SQLException {
		BaseDao.multiTransacaoFinalizada = true;
		super.afterInsert();
	}
	
}
