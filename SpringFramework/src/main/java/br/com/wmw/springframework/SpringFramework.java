package br.com.wmw.springframework;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.wmw.springframework.domain.Pedido;
import br.com.wmw.springframework.service.PedidoService;

public class SpringFramework {

	public static void main(String[] args) throws SQLException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		PedidoService pedidoService = context.getBean(PedidoService.class);

		Pedido pedido;

		pedido = new Pedido(1, "Transporte Ltda.");
		pedido.addItem(1, "Papel A4", 12.20);
		pedido.addItem(2, "Caneta Bic", 1.20);
		pedido.addItem(3, "Lapis Castel", 1.75);
		pedidoService.insert(pedido);
//
//		pedido = new Pedido(2, "Lanchonete Ltda.");
//		pedido.addItem(1, "Coca-Cola", 2.20);
//		pedido.addItem(2, "Suco Valle", 1.90);
//		pedido.addItem(3, "Ciclete big", 0.35);
//		pedido.addItem(4, "Sonho Valsa", 0.60);
//		pedidoService.insert(pedido);

//		pedido = new Pedido(3, "WMW Systems Ltda.");
//		pedido.addItem(1, "Teclado USB", 22.90);
//		pedido.addItem(1, "Mouse USB", 19.90);
//		pedidoService.insert(pedido);


		//--

//		Pedido pedido1 = new Pedido();
//		pedido1.setCdPedido(1);
//		pedido1 =  pedidoService.findByPrimaryKey(pedido1);
//		System.out.println(pedido1);
//
//		Pedido pedido2 = new Pedido();
//		pedido2.setCdPedido(2);
//		pedido2 =  pedidoService.findByPrimaryKey(pedido2);
//		System.out.println(pedido2);

	}

}
