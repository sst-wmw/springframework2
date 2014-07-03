package br.com.wmw.springframework.domain;

import java.util.ArrayList;
import java.util.List;


public class Pedido {

	private Integer cdPedido;
	private String nmCliente;
	private Double vlPedido;
	private List<ItemPedido> items;

	public Pedido() {
		this(null, null);
	}

	public Pedido(final Integer cdPedido, final String nmCliente) {
		this.cdPedido = cdPedido;
		this.nmCliente = nmCliente;
		this.vlPedido = 0d;
		this.items = new ArrayList<ItemPedido>();
	}

	public Integer getCdPedido() {
		return cdPedido;
	}

	public void setCdPedido(Integer cdPedido) {
		this.cdPedido = cdPedido;
	}

	public String getNmCliente() {
		return nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public Double getVlPedido() {
		return vlPedido;
	}

	public void setVlPedido(Double vlPedido) {
		this.vlPedido = vlPedido;
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}

	public void addItem(final ItemPedido item) {
		if (item != null) {
			items.add(item);
			this.vlPedido += item.getVlProduto();
		}
	}

	public void addItem(final Integer cdProduto, final String dsProduto, final Double vlProduto) {
		ItemPedido item = new ItemPedido(this.cdPedido, cdProduto, dsProduto, vlProduto);
		addItem(item);
	}

	@Override
	public String toString() {
		StringBuffer value = new StringBuffer();
		value.append("================================================\n");
		value.append(String.format(" %s - %s (R$ %s) \n", getCdPedido(), getNmCliente(), getVlPedido()));
		value.append("================================================\n");
		if (items != null) {
			value.append("Código\t Descrição \tPreço \n");
			for (ItemPedido item : items) {
				value.append(String.format("%s\t %s\t %s \n", item.getCdProduto(), item.getDsProduto(), item.getVlProduto()));
			}
		}
		return value.toString();
	}

}
