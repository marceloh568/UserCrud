package br.com.usercrud.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.usercrud.util.VerificadorUtil;

public class ConverterInputMask implements Converter {

	@Override  
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {  
        if(VerificadorUtil.naoEstaNuloOuVazio(valor)) {  
            valor = valor.toString().replaceAll("[- /.]", "");  
            valor = valor.toString().replaceAll("[-()]", "");  
        }  
        return valor;  
    }  
  
    @Override  
    public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {  
        return valor.toString();  
    }  
}
