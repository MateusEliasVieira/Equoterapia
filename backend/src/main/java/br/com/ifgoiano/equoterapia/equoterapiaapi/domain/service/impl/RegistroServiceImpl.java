package br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.RegistroModel;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.repository.RegistroRepository;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service.RegistroService;

@Service
public class RegistroServiceImpl implements RegistroService{

	@Autowired
	private RegistroRepository registroRepository;
	
	@Override
	public RegistroModel salvar(RegistroModel registroModel) {
		return registroRepository.save(registroModel);
	}

}
