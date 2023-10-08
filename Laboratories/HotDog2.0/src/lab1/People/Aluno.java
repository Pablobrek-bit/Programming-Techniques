package lab1.People;

public class Aluno extends People{


	private int matricula;
	
	public Aluno(String nome, int matricula) {
		this.name = nome;
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}	
}
