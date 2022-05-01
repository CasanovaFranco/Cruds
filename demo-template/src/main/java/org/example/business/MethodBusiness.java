package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.entities.Method;
import org.example.repository.MethodRepository;

@Named
public class MethodBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private MethodRepository methodRepository;

	public List<Method> getAllMethod() throws Exception {
		return methodRepository.findAllMethods();

	}
	
}
