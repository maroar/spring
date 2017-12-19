package entidades;

import java.util.Set; 
import java.util.HashSet;
import javax.persistence.*;

@Entity
@Table(name = Medicamento.tableName)
public class Medicamento {

    public static final String tableName = "medicamentos";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medicamento_id")
    private long id;
    
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prescricoes_medicamentos",
        joinColumns = @JoinColumn(name = "medicamento_id", referencedColumnName = "medicamento_id"),
        inverseJoinColumns = @JoinColumn(name = "prescricao_id", referencedColumnName = "prescricao_id"))
    private Set<Prescricao> prescricoes = new HashSet<Prescricao>();

    public Medicamento() {
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
    
}

