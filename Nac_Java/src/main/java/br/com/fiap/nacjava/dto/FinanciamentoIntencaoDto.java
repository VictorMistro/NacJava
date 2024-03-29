package br.com.fiap.nacjava.dto;

import javax.validation.constraints.NotBlank;

import br.com.fiap.nacjava.entity.FinanciamentoIntencaoEntity;
public class FinanciamentoIntencaoDto {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String acompanhante;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAcompanhante() {
        return acompanhante;
    }
    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }
    
    public FinanciamentoIntencaoEntity toEntity() {
    	FinanciamentoIntencaoEntity entity = new FinanciamentoIntencaoEntity();
        entity.setId(this.id);
        entity.setEmail(this.email);
        entity.setNome(this.nome);
        entity.setAcompanhante(this.acompanhante);
        return entity;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((acompanhante == null) ? 0 : acompanhante.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FinanciamentoIntencaoDto other = (FinanciamentoIntencaoDto) obj;
        if (acompanhante == null) {
            if (other.acompanhante != null)
                return false;
        } else if (!acompanhante.equals(other.acompanhante))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
    
    
}
