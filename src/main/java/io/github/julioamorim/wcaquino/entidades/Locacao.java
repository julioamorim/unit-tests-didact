package io.github.julioamorim.wcaquino.entidades;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Locacao {

	private Usuario usuario;
	private Filme filme;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;

}