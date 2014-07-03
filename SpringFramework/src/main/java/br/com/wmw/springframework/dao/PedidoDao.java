package br.com.wmw.springframework.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.wmw.springframework.domain.Pedido;

public class PedidoDao {

	private JdbcTemplate jdbcTemplate;

	private static final String COMMAND_INSERT = "insert into pedido (cdPedido, nmCliente, vlPedido) values (?, ?, ?)";
	private static final String COMMAND_FINDPK = "select cdPedido, nmCliente, vlPedido from pedido where cdpedido = ?";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(final Pedido pedido) throws SQLException {
		Object[] params = new Object[] { pedido.getCdPedido(), pedido.getNmCliente(), pedido.getVlPedido() };
		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.DECIMAL };
		jdbcTemplate.update(COMMAND_INSERT, params, types);
	}

	public Pedido findByPrimaryKey(final Pedido pedido) throws SQLException {
		Object[] params = new Object[] { pedido.getCdPedido() };
		return jdbcTemplate.queryForObject(COMMAND_FINDPK, params, new RowMapper<Pedido>() {
			@Override
			public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
				Pedido pedido = new Pedido();
				pedido.setCdPedido(rs.getInt("cdPedido"));
				pedido.setNmCliente(rs.getString("nmCliente"));
				pedido.setVlPedido(rs.getDouble("vlPedido"));
				return pedido;
			}
		});
	}


}
