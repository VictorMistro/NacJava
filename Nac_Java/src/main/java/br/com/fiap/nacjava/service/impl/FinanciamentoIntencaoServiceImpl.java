package br.com.fiap.nacjava.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fiap.nacjava.dto.FinanciamentoIntencaoDto;
import br.com.fiap.nacjava.entity.FinanciamentoIntencaoEntity;
import br.com.fiap.nacjava.repository.FinanciamentoIntencaoRepository;
import br.com.fiap.nacjava.service.FinanciamentoIntencaoService;
@Service
public class FinanciamentoIntencaoServiceImpl implements FinanciamentoIntencaoService{
    
    @Autowired
    FinanciamentoIntencaoRepository repository; 
    @Override
    public FinanciamentoIntencaoDto salvarIntencoes(FinanciamentoIntencaoDto intencaoDto) {     
    	FinanciamentoIntencaoEntity entity = intencaoDto.toEntity();        
        entity =  repository.save(entity);
        FinanciamentoIntencaoDto convidadosDto = fromConvidadosEntityToConvidadosDto(entity);
        return convidadosDto;
    }
    
    @Override
    public List<FinanciamentoIntencaoDto> listarIntencoes() {   
        
        List<FinanciamentoIntencaoEntity> listaConvidadosEntity = repository.findAll(); 
        
        List<FinanciamentoIntencaoDto> listaConvidadosDto = fromConvidadosEntityToConvidadosDto(listaConvidadosEntity);
        
        return listaConvidadosDto;
    }
    @Override
    public FinanciamentoIntencaoDto editarIntencoes(Long id) {
        
    	FinanciamentoIntencaoEntity entity = repository.findById(id).get();
        
    	FinanciamentoIntencaoDto convidadoDto = fromConvidadosEntityToConvidadosDto(entity);
        
        return convidadoDto;
    }
    @Override
    public void excluirIntencoes(Long id) {
        repository.deleteById(id);  
    }
    
    private FinanciamentoIntencaoDto fromConvidadosEntityToConvidadosDto(FinanciamentoIntencaoEntity entity) {
        FinanciamentoIntencaoDto dto = new FinanciamentoIntencaoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setAcompanhante(entity.getAcompanhante());      
        return dto;
    }
    
    private List<FinanciamentoIntencaoDto> fromConvidadosEntityToConvidadosDto(List<FinanciamentoIntencaoEntity> listaEntity) {     
        List<FinanciamentoIntencaoDto> listaConvidadoDto = new ArrayList<>();
        
        for (FinanciamentoIntencaoEntity convidadosEntity : listaEntity) {
        	FinanciamentoIntencaoDto dto = new FinanciamentoIntencaoDto();          
            dto.setId(convidadosEntity.getId());
            dto.setNome(convidadosEntity.getNome());
            dto.setEmail(convidadosEntity.getEmail());
            dto.setAcompanhante(convidadosEntity.getAcompanhante());    
            
            listaConvidadoDto.add(dto);
        }           
        return listaConvidadoDto;
    }
}
