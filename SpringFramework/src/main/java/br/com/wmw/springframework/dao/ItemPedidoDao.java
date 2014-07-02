package br.com.wmw.springframework.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.wmw.springframework.domain.ItemPedido;

public class ItemPedidoDao {

	private JdbcTemplate jdbcTemplate;

	private static final String COMMAND_INSERT = "insert into itemPedido (cdPedido, cdProduto, dsProduto, vlProduto) values (?, ?, ?, ?)";
	private static final String COMMAND_FIND_EXAMPLES = "select cdPedido, cdProduto, dsProduto, vlProduto from itemPedido where cdPedido = ?";


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(final ItemPedido itemPedido) {
		Object[] params = new Object[] { itemPedido.getCdPedido(), itemPedido.getCdProduto(), itemPedido.getDsProduto(), itemPedido.getVlProduto() };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.DECIMAL };
		jdbcTemplate.update(COMMAND_INSERT, params, types);
	}

	public void insert(final List<ItemPedido> items) {
		for (ItemPedido itemPedido : items) {
			insert(itemPedido);
		}
	}

	public List<ItemPedido> findAllByExamples(final ItemPedido itemPedido) throws SQLException {
		List<ItemPedido> items = new ArrayList<ItemPedido>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(COMMAND_FIND_EXAMPLES, itemPedido.getCdPedido());
		for (Map<String, Object> row : rows) {
			ItemPedido item = new ItemPedido();
			item.setCdPedido( ((BigDecimal) row.get("cdPedido")).intValue());
			item.setCdProduto( ((BigDecimal)row.get("cdProduto")).intValue());
			item.setDsProduto((String)row.get("dsProduto"));
			item.setVlProduto( ((BigDecimal)row.get("vlProduto")).doubleValue());
			items.add(item);
		}
		return items;
	}



}
