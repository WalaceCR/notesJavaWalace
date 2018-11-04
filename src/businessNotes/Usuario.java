package businessNotes;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {
	
	private String nome;
	private String cpf;
	@IdadeMinima(valor=18)
	private LocalDate dataNascimento;
	public Usuario(String string, String string2, LocalDate of) {
		// TODO Auto-generated constructor stub
		this.nome = string;
		this.cpf = string2;
		this.dataNascimento = of;
	}
	/**
	 * @return the dataNascimento
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public boolean usuarioValido(Usuario usuario){
	   //usando expressões regulares
	   if(!usuario.getNome().matches("[a-zA-Záàâãéèêíïóôõöúçñ\\s]+")){
	      return false;
	   }
	   //usando expressões regulares
	   if(!usuario.getCpf().matches("[^0-9]+")){
	      return false;
	   }
	   //validação entre datas
	   return Period.between(usuario.getDataNascimento(), LocalDate.now()).getYears() >= 18;
	}

}
