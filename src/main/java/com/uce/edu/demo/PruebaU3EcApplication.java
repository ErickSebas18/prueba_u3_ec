package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Compras;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IVentaService;

@SpringBootApplication
public class PruebaU3EcApplication implements CommandLineRunner{

	private static Logger logJava = Logger.getLogger(PruebaU3EcApplication.class);
	
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IVentaService iVentaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaU3EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//PUNTO 1
		Producto producto = new Producto();
		producto.setCodigoBarras("421346");
		producto.setNombre("Galletas Oreo");
		producto.setCategoria("Dulces");
		producto.setStock(50);
		producto.setPrecio(new BigDecimal(2.2));
		
		//this.iProductoService.insertarProducto(producto);
		//this.iProductoService.insertarProducto(producto);
		logJava.info("Se ha insertado el producto 1");
		
		Producto producto2 = new Producto();
		producto2.setCodigoBarras("132164");
		producto2.setNombre("Sabanas");
		producto2.setCategoria("Hogar");
		producto2.setStock(20);
		producto2.setPrecio(new BigDecimal(20));
		
		//this.iProductoService.insertarProducto(producto2);
		//this.iProductoService.insertarProducto(producto2);
		logJava.info("Se ha insertado el producto 2");
		
		//PUNTO 2
		
		Compras compra = new Compras();
		compra.setCodigoBarras("494316");
		compra.setCantidad(6);
		
		Compras compra2 = new Compras();
		compra2.setCodigoBarras("421346");
		compra2.setCantidad(123);
		
		Compras compra3 = new Compras();
		compra3.setCodigoBarras("132164");
		compra3.setCantidad(14);
		
		List<Compras>detalles=new ArrayList<>();
		detalles.add(compra);
		detalles.add(compra2);
		detalles.add(compra3);
		
		this.iVentaService.insertarVenta(detalles, "13215461", "4516");
		
		
		
		
		
		//PUNTO 3
		//logJava.info(this.iProductoRepository.buscarProductoSimple(producto2.getCodigoBarras(), producto2.getNombre(), 20));
	}

}
