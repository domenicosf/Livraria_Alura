package br.com.alura.alura_lib.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.alura.alura_lib.tx.annotation.Transacional;

@Interceptor
@Transacional
// @Priority(Interceptor.Priority.APPLICATION) - Ativa o interceptor no escopo
// de aplicacao sem necessitar criar o arquivo beans.xml
public class GerenciadorDeTransacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1392064408660679407L;

	private Transacionado transacionado;

	@Inject
	public GerenciadorDeTransacao(Transacionado transacionado) {
		this.transacionado = transacionado;
	}

	@AroundInvoke
	public Object interceptar(InvocationContext context) {

		return transacionado.executaComTransacao(context);

	}

}
