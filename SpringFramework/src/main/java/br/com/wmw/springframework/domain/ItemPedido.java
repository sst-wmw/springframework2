package br.com.wmw.springframework.domain;

public class ItemPedido {

	private Integer cdPedido;
	private Integer cdProduto;
	private String dsProduto;
	private Double vlProduto;

	public ItemPedido() {
		this(null, null, null, null);
	}

	public ItemPedido(final Integer cdPedido, final Integer cdProduto, final String dsProduto, final Double vlProduto) {
		this.cdPedido = cdPedido;
		this.cdProduto = cdProduto;
		this.dsProduto = dsProduto;
		this.vlProduto = vlProduto;
	}

	public Integer getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(Integer cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

	public Double getVlProduto() {
		return vlProduto;
	}

	public void setVlProduto(Double vlProduto) {
		this.vlProduto = vlProduto;
	}

	public Integer getCdPedido() {
		return cdPedido;
	}

	public void setCdPedido(Integer cdPedido) {
		this.cdPedido = cdPedido;
	}

}
