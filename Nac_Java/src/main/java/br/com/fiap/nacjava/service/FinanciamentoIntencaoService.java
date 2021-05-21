package br.com.fiap.nacjava.service;

import java.util.List;
import br.com.fiap.nacjava.dto.FinanciamentoIntencaoDto;
public interface FinanciamentoIntencaoService {
	FinanciamentoIntencaoDto salvarIntencoes(FinanciamentoIntencaoDto intencaoDto);
    
    List<FinanciamentoIntencaoDto> listarIntencoes();
    
    FinanciamentoIntencaoDto editarIntencoes(Long id);
    
    void excluirIntencoes(Long id);
    
}