package domain;

import java.util.ArrayList;

public class Pedido {
	
	private int cdPedido;
	private double vlPedido;
	private ArrayList<ItemPedido> listItemPedido;

	public int getCdPedido() {
		return cdPedido;
	}

	public void setCdPedido(int cdPedido) {
		this.cdPedido = cdPedido;
	}

	public double getVlPedido() {
		return vlPedido;
	}

	public void setVlPedido(double vlPedido) {
		this.vlPedido = vlPedido;
	}

	public ArrayList<ItemPedido> getListItemPedido() {
		return listItemPedido;
	}

	public void setListItemPedido(ArrayList<ItemPedido> listItemPedido) {
		this.listItemPedido = listItemPedido;
	}
	
}
