package br.com.quintanoite.bean;

import br.com.quintanoite.dao.FuncionarioDao;
import br.com.quintanoite.domain.Funcionario;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

    private List<Funcionario> Funcionarios;

    public List<Funcionario> getFuncionarios() {
        return Funcionarios;
    }

    public void setFuncionarios(List<Funcionario> Funcionarios) {
        this.Funcionarios = Funcionarios;
    }

    @PostConstruct
    public void listar() {
        try {
            FuncionarioDao dao = new FuncionarioDao();
            Funcionarios = dao.listar();
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao listar Funcionario");
            e.printStackTrace();
        }
    }
}
