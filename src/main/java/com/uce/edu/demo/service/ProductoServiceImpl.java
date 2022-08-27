package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertarProducto(Producto producto){
		// TODO Auto-generated method stub
		
		Producto productoBuscado = this.iProductoRepository.buscar(producto.getCodigoBarras());
		
			if(productoBuscado == null) {
				this.iProductoRepository.insertar(producto);
			} else {
				productoBuscado.setStock(productoBuscado.getStock() + producto.getStock());
				this.iProductoRepository.actualizar(productoBuscado);
			}
		}

}
