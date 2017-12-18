package repositorios;
 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
 
import entidades.Medicamento;
 
public interface RepositorioMedicamento extends JpaRepository<Medicamento, Long> {

    Medicamento findByNome(String nome);

    Medicamento findById(Long id);

}