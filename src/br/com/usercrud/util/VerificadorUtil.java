package br.com.usercrud.util;

import java.util.List;
import org.apache.commons.lang.StringUtils;

public class VerificadorUtil {
    public VerificadorUtil() {
    }

    public static Object selecionarValorCondicional(Boolean condicao, Object valorSeVerdade, Object valorSeFalso) {
        return condicao.booleanValue()?valorSeVerdade:valorSeFalso;
    }

    public static boolean estaNulo(Object objeto) {
        return objeto == null;
    }

    public static boolean naoEstaNulo(Object objeto) {
        return objeto != null;
    }

    public static boolean estaVazio(Object valor) {
        return StringUtils.isEmpty(valor.toString());
    }

    public static boolean naoEstaNuloOuVazio(Object objeto) {
        Boolean isNaoEstaNuloOuVazio = Boolean.valueOf(objeto != null && !StringUtils.isEmpty(objeto.toString()));
        return !(objeto instanceof List)?isNaoEstaNuloOuVazio.booleanValue():isNaoEstaNuloOuVazio.booleanValue() && !((List)objeto).isEmpty();
    }

    public static boolean estaNuloOuVazio(Object valor) {
        return estaNulo(valor) || estaVazio(valor);
    }

    public static void verificarNulo(Object objeto, String mensagemErro) {
        if(objeto == null) {
            throw new RuntimeException(mensagemErro);
        }
    }

    public static boolean isListaNulaOuVazia(List<? extends Object> lista) {
        return estaNulo(lista) || isListaVazia(lista);
    }

    public static boolean isListaVazia(List<? extends Object> lista) {
        return lista.isEmpty();
    }

    public static boolean isListaComElementos(List<? extends Object> lista) {
        return !isListaVazia(lista);
    }
}
