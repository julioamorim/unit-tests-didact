package io.github.julioamorim.servicos;

import static io.github.julioamorim.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;

import io.github.julioamorim.wcaquino.entidades.Filme;
import io.github.julioamorim.wcaquino.entidades.Locacao;
import io.github.julioamorim.wcaquino.entidades.Usuario;

public class LocacaoService {

	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		// Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// TODO adicionar método para salvar

		return locacao;
	}

}