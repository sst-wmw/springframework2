package domain;

public class ItemPedido {
	
	private int cdItemPedido;
	private int cdPedido;
	private int cdProduto;
	private double vlItem;
	
	public int getCdItemPedido() {
		return cdItemPedido;
	}
	
	public void setCdItemPedido(int cdItemPedido) {
		this.cdItemPedido = cdItemPedido;
	}
	
	public int getCdPedido() {
		return cdPedido;
	}
	
	public void setCdPedido(int cdPedido) {
		this.cdPedido = cdPedido;
	}
	
	public int getCdProduto() {
		return cdProduto;
	}
	
	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}
	
	public double getVlItem() {
		return vlItem;
	}
	
	public void setVlItem(double vlItem) {
		this.vlItem = vlItem;
	}
	
}
