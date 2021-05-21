package br.com.fiap.nacjava.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.fiap.nacjava.dto.FinanciamentoIntencaoDto;
import br.com.fiap.nacjava.entity.FinanciamentoIntencaoEntity;
import br.com.fiap.nacjava.service.FinanciamentoIntencaoService;

@Controller
public class FinanciamentoIntencaoController {
    @Autowired
    private FinanciamentoIntencaoService service; 
    
    @PostMapping("/home")
    public String salvarIntencao(@Valid FinanciamentoIntencaoDto intencaoDto, BindingResult result) {
        
        if(!result.hasErrors()) {
            service.salvarIntencoes(intencaoDto);   
            return "redirect:/home";
        }           
        
        return "redirect:/erro";
    }
    @GetMapping("/home")
    public ModelAndView listar() {
        ModelAndView view = new ModelAndView("intencoes/ListaIntencoes");
        List<FinanciamentoIntencaoDto> intencoes = service.listarIntencoes();
        
        view.addObject("intencao", new FinanciamentoIntencaoEntity());
        view.addObject("intencoes", intencoes);
        return view;
    }
    
    @GetMapping("/home/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        
    	FinanciamentoIntencaoDto intencao = service.editarIntencoes(id);    
        
        ModelAndView view = new ModelAndView("intencoes/telaIntencao");
        view.addObject("intencao", intencao);       
        return view;
    }
}