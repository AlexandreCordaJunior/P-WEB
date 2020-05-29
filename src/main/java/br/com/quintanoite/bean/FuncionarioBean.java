package br.com.quintanoite.bean;

import br.com.quintanoite.dao.FuncionarioDao;
import br.com.quintanoite.domain.Funcionario;
import br.com.quintanoite.util.JSFUtil;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

    private String acao;

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    Funcionario funcionario;

    public Funcionario getFuncionario() {
        if(funcionario == null) funcionario = new Funcionario();
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

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

    public void novo() {
        funcionario = new Funcionario();
    }

    public void carregarCadastro() {
        try {
            acao = JSFUtil.getParam("funacao");
            String valor = JSFUtil.getParam("funcad");
            if(valor != null) {
                Long codigo = Long.parseLong(valor);
                FuncionarioDao dao = new FuncionarioDao();
                funcionario = dao.buscar(codigo);
            }
            else{
                novo();
            }
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao listar Funcionario");
            e.printStackTrace();
        }
    }

    public void salvar() {
        try {
            FuncionarioDao dao = new FuncionarioDao();
            dao.salvar(funcionario);
            novo();
            Messages.addGlobalInfo("Funcionario salvo com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao salvar Funcionario");
            e.printStackTrace();
        }
    }

    public void excluir() {
        try {
            FuncionarioDao dao = new FuncionarioDao();
            dao.excluir(funcionario);
            novo();
            Messages.addGlobalInfo("Funcionario excluido com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao excluir Funcionario");
            e.printStackTrace();
        }
    }

    public void editar() {
        try {
            FuncionarioDao dao = new FuncionarioDao();
            dao.editar(funcionario);
            novo();
            Messages.addGlobalInfo("Funcionario editado com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao editar Funcionario");
            e.printStackTrace();
        }
    }
}
