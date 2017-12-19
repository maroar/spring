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

import entidades.Paciente;
import repositorios.RepositorioPaciente;

@Controller
@RequestMapping("/pacientes")
public class ControladorPaciente {

    private RepositorioPaciente repositorioPaciente;
   
    @Autowired
    public ControladorPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Paciente pacientes(@PathVariable("id") Long id) {
        Paciente paciente = repositorioPaciente.findById(id);
        return paciente;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String pacientes(Model model) {
        List<Paciente> listaDePacientes = repositorioPaciente.findAll();
        if (listaDePacientes != null) {
            model.addAttribute("pacientes", listaDePacientes);
        }
        return "pacientes";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String pacientes(
        @RequestParam(value="nome", defaultValue="NoName") String nome,
        @RequestParam(value="cpf", defaultValue="NoCPF") String cpf,
        @RequestParam(value="nascimento", defaultValue="NoNascimento") String nascimento,
        Paciente paciente) {
        paciente.setNome(nome);
        paciente.setCpf(cpf);
        paciente.setNascimento(nascimento);
        repositorioPaciente.save(paciente);
        return "redirect:/pacientes";
    }

}
