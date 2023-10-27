package lab1.Model.People.Client;

public class Client {

	private String name;
	private String id;
	
	public Client(String nome, String matricula) {
		this.name = nome;
		this.id = matricula;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
