package entidades;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;

@Entity
@Table(name = Medico.tableName)
public class Medico {

    public static final String tableName = "medicos";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medico_id") 
    private long id;
    
    private String nome;

    private String cpf;

    private String nascimento;

    private String cro;

    @OneToMany(mappedBy = "medico")
    private Set<Prescricao> skills = new HashSet<Prescricao>();

    public Medico() {
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

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

}
