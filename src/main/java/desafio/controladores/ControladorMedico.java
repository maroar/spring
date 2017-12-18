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

import entidades.Medico;
import repositorios.RepositorioMedico;

@Controller
@RequestMapping("/")
public class ControladorMedico {

    private RepositorioMedico repositorioMedico;
   
    @Autowired
    public ControladorMedico(RepositorioMedico repositorioMedico) {
        this.repositorioMedico = repositorioMedico;
    }

    @ResponseBody
    @RequestMapping(value = "/medicos/{id}", method = RequestMethod.GET)
    public Medico medicos(@PathVariable("id") Long id) {
        Medico medico = repositorioMedico.findById(id);
        return medico;
    }

    @RequestMapping(value = "/medicos", method = RequestMethod.GET)
    public String medicos(Model model) {
        List<Medico> listaDeMedicos = repositorioMedico.findAll();
        if (listaDeMedicos != null) {
            model.addAttribute("medicos", listaDeMedicos);
        }
        return "medicos";
    }

    @RequestMapping(value = "/medicos", method = RequestMethod.POST)
    public String medicos(
        @RequestParam(value="nome", defaultValue="NoName") String nome,
        @RequestParam(value="cpf", defaultValue="NoCPF") String cpf,
        @RequestParam(value="nascimento", defaultValue="NoNascimento") String nascimento,
        Medico medico) {
        medico.setNome(nome);
        medico.setCpf(cpf);
        medico.setNascimento(nascimento);
        repositorioMedico.save(medico);
        return "redirect:/medicos";
    }
}

