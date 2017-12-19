package entidades;

import javax.persistence.*;

@Entity
@Table(name = Paciente.tableName)
public class Paciente {

    public static final String tableName = "pacientes";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") 
    private long id;
    
    private String nome;

    private String cpf;

    private String nascimento;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    
}
