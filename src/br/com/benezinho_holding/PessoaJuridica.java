package br.com.benezinho_holding;

import java.time.LocalDate;
import java.util.Collection;

public class PessoaJuridica extends Pessoa{
    private String CNPJ;
    private Collection<Pessoa> Socios;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Long id, String nome, LocalDate nascimento, String CNPJ, Collection<Pessoa> socios) {
        super(id, nome, nascimento);
        this.CNPJ = CNPJ;
        Socios = socios;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Collection<Pessoa> getSocios() {
        return Socios;
    }

    public void setSocios(Collection<Pessoa> socios) {
        Socios = socios;
    }


    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "CNPJ='" + CNPJ + '\'' +
                ", Socios=" + Socios +
                "} " + super.toString();
    }
}
