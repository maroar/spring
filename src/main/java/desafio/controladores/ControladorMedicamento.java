package controladores;

import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import entidades.Medicamento;
import repositorios.RepositorioMedicamento;

@Controller
@RequestMapping("/medicamentos")
public class ControladorMedicamento {

    private RepositorioMedicamento repositorioMedicamento;
   
    @Autowired
    public ControladorMedicamento(RepositorioMedicamento repositorioMedicamento) {
        this.repositorioMedicamento = repositorioMedicamento;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Medicamento medicamentos(@PathVariable("id") Long id) {
        Medicamento medicamento = repositorioMedicamento.findById(id);
        return medicamento;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String medicamentos(Model model) {
        List<Medicamento> listaDeMedicamentos = repositorioMedicamento.findAll();
        if (listaDeMedicamentos != null) {
            model.addAttribute("medicamentos", listaDeMedicamentos);
        }
        return "medicamentos";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String medicamentos(@RequestParam(value="nome", defaultValue="NoName") String nome, Medicamento medicamento) {
        medicamento.setNome(nome);
        repositorioMedicamento.save(medicamento);
        return "redirect:/medicamentos";
    }
    
}

