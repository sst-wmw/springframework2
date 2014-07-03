package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Pedido;


public class PedidoDao extends BaseDao {
	
	@Override
	public void beforeInsert() throws SQLException {
		BaseDao.multiTransacaoIniciada = true;
		super.beforeInsert();
	}
	
	@Override
	public void doInsert(Object obj) {
		Pedido pedido = (Pedido) obj;
		ResultSet resultSet = BaseDao.executeSql("INSERT INTO PEDIDO VALUES (" + pedido.getCdPedido() + ", " + pedido.getVlPedido() + ")");
		pedido.setCdPedido(getRowId(resultSet));
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
