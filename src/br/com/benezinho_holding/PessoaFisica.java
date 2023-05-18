package br.com.benezinho_holding;

import java.time.LocalDate;
import java.util.Collection;

public class PessoaFisica extends Pessoa{
    private String CPF;
    private Collection<Pessoa> filhos;

    public PessoaFisica() {
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Collection<Pessoa> getFilhos() {
        return filhos;
    }

    public void setFilhos(Collection<Pessoa> filhos) {
        this.filhos = filhos;
    }

    public PessoaFisica(Long id, String nome, LocalDate nascimento, String CPF, Collection<Pessoa> filhos) {
        super(id, nome, nascimento);
        this.CPF = CPF;
        this.filhos = filhos;
    }


    @Override
    public String toString() {
        return "PessoaFisica{" +
                "CPF='" + CPF + '\'' +
                ", filhos=" + filhos +
                "} " + super.toString();
    }
}
