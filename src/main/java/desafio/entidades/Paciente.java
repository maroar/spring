package entidades;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;

@Entity
@Table(name = Paciente.tableName)
public class Paciente {

    public static final String tableName = "pacientes";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "paciente_id") 
    private long id;
    
    private String nome;

    private String cpf;

    private String nascimento;

    @OneToMany(mappedBy = "paciente")
    private Set<Prescricao> skills = new HashSet<Prescricao>();

    public Paciente() {
    }

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
