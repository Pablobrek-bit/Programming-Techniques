package lab1.People;

public class Server extends People {
    private int siape;

    public Server(String nome, int matricula) {
        this.name = nome;
        this.siape = matricula;
    }

    public int getSiape() {
        return siape;
    }
}
