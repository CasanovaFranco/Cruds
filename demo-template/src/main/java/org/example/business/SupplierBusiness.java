package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.entities.Supplier;
import org.example.repository.SupplierRepository;

@Named
public class SupplierBusiness implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SupplierRepository supplierRepository;
	
	public List<Supplier> getAllSuppliers()throws Exception{
		return supplierRepository.findAll();
	}	
	
}
