package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicamento {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(name="nome", nullable=false)
    private String nome;

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

