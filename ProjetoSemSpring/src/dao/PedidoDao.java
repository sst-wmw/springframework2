package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.ItemPedido;
import domain.Pedido;


public class PedidoDao extends BaseDao {
	
	@Override
	public void doInsert(Object obj) {
		Pedido pedido = (Pedido) obj;
		ResultSet resultSet = BaseDao.executeSql("INSERT INTO PEDIDO VALUES(" + pedido.getCdPedido() + ", " + pedido.getVlPedido() + ")");
		int cdPedido = getRowId(resultSet);
		ArrayList<ItemPedido> listItemPedido = pedido.getListItemPedido();
		int size = listItemPedido.size();
		for (int i = 0; i < size; i++) {
			ItemPedido item = listItemPedido.get(i);
			BaseDao.executeSql("INSERT INTO ITEMPEDIDO VALUES(NULL, " + cdPedido + ", " + item.getVlItem() + ")");
		}
		
	}

	private int getRowId(ResultSet resultSet) {
		int pId = 0;
		try {
			if (resultSet.next()) {
				pId = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pId;
	}
	
}
