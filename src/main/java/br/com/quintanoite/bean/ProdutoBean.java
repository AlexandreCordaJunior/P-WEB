package br.com.quintanoite.bean;

import br.com.quintanoite.dao.ProdutoDao;
import br.com.quintanoite.domain.Produto;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

    private List<Produto> Produtos;

    public List<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(List<Produto> Produtos) {
        this.Produtos = Produtos;
    }

    @PostConstruct
    public void listar() {
        try {
            ProdutoDao dao = new ProdutoDao();
            Produtos = dao.listar();
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao listar Produto");
            e.printStackTrace();
        }
    }
}
