package br.com.quintanoite.converter;

import br.com.quintanoite.dao.FornecedorDao;
import br.com.quintanoite.domain.Fornecedor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("fornecedorConverter")
public class FornecedorConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        try{
            Long codigo = Long.parseLong(s);
            FornecedorDao dao = new FornecedorDao();
            Fornecedor fornecedor = dao.buscar(codigo);
            return fornecedor;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        try {
            Fornecedor fornecedor = (Fornecedor) o;
            Long codigo = fornecedor.getCodigo();
            return codigo.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
