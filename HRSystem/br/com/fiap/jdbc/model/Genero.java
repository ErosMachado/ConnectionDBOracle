package br.com.fiap.jdbc.model;

public enum Genero {

	MASCULINO("M"), FEMININO("F"), OUTRO("O"), NAO_INFORMADO("NI"), PREFIRO_NAO_DIZER("ND");

	private final String codigo;

	// Construtor do enum para associar o código com a string
	Genero(String codigo) {
		this.codigo = codigo;
	}

	// Método para obter o código associado ao enum (o valor que será salvo no
	// banco)
	public String getCodigo() {
		return codigo;
	}

	// Método para converter uma String para o valor do Enum
	public static Genero fromCodigo(String codigo) {
		for (Genero genero : Genero.values()) {
			if (genero.getCodigo().equalsIgnoreCase(codigo)) {
				return genero;
			}
		}
		throw new IllegalArgumentException("Código de gênero inválido: " + codigo);
	}
}
