import br.com.holding.authentication.model.Profile;
import br.com.holding.authentication.model.Role;
import br.com.holding.authentication.model.User;
import br.com.holding.pessoa.model.Pessoa;
import br.com.holding.pessoa.model.PessoaFisica;
import br.com.holding.pessoa.model.PessoaJuridica;
import br.com.holding.sistema.model.Sistema;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Objects;

public class Main {


    public static PessoaFisica novaPessoa(Long id, String nome, LocalDate nascimento, String cpf){
        PessoaFisica pf = new PessoaFisica();
        pf.setId(id);
        pf.setNome(nome);
        pf.setNascimento(nascimento);
        pf.setCpf(cpf);

        return pf;
    }

    public static PessoaJuridica novaPessoaJuridica(Long id, String nome, LocalDate fundacao, String CNPJ){
        PessoaJuridica pj = new PessoaJuridica();
        pj.setId(id);
        pj.setNome(nome);
        pj.setNascimento(fundacao);
        pj.setCNPJ(CNPJ);

        return pj;
    }

    public static User novoUsuario(Long id, String email, String password, Pessoa pessoa){
        User lg = new User();
        lg.setId(id);
        lg.setEmail(email);
        lg.setPassword(password);
        lg.setPessoa(pessoa);

        return lg;
    }

    public static Profile novoProfile(Long id, String nome){
        Profile pr = new Profile();
        pr.setId(id);
        pr.setNome(nome);

        return pr;
    }

    public static Role novoRole(Long id, String nome, String descricao, Sistema sistema){
        Role  rl = new Role();
        rl.setId(id);
        rl.setNome(nome);
        rl.setDescricao(descricao);
        rl.setSistema(sistema);

        return rl;
    }

    public static Sistema novoSistema(Long id, String nome, String sigla){
        Sistema st = new Sistema();
        st.setId(id);
        st.setNome(nome);
        st.setSigla(sigla);

        return st;
    }


    public static void main(String[] args) {

        PessoaFisica alberto = novaPessoa
                (12345L,"Alberto Rubinho Peruchi",
                        LocalDate.of(2002,1,11),"123.456.789-10");
        PessoaFisica albertinho = novaPessoa
                (12345L,"Albertinho",
                        LocalDate.of(2050,1,12),"123.456.789-11");

        PessoaJuridica manai = novaPessoaJuridica
                (9876L, "Manai Restaurante",
                        LocalDate.of(2015,9,14), "89.658.123/0001-23");

        User albertoperuchi11 = novoUsuario
                (123456L, "albertoperuchi11@gmail.com",
                        "alberto123",alberto);
        Profile garcom = novoProfile(99191L,"Garçom do Manai");

        Sistema restaurante = novoSistema(1234L,"Manai","MN");

        Role fechaCaixaBar = novoRole(1234L,"Open-Caixa","Abre e fecha o caixa",restaurante);

        //Coleção filhos
        alberto.addFilho(albertinho);

        //Coleção sócios
        manai.addSocio(alberto).addSocio(albertinho);

        //Coleção profiles
        alberto.addProfile(garcom);

        //Coleção roles
        garcom.addRole(fechaCaixaBar);

        //Coleção responsaveis
        restaurante.addResponsavel(alberto);


        var login = JOptionPane.showInputDialog("Digite seu email: ");
        var senha = JOptionPane.showInputDialog("Digite sua senha: ");

        if(Objects.equals(login, albertoperuchi11.getEmail()) && Objects.equals(senha, albertoperuchi11.getPassword())){
            System.out.println("login valido");
        }else{
            System.out.println("Login invalido Email ou senha Invalido! ");
        }

    }
}