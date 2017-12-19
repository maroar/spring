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
import java.util.Set;
import java.util.HashSet;

import entidades.Medico;
import repositorios.RepositorioMedico;
import entidades.Medicamento;
import repositorios.RepositorioMedicamento;
import entidades.Paciente;
import repositorios.RepositorioPaciente;
import entidades.Prescricao;
import repositorios.RepositorioPrescricao;

@Controller
@RequestMapping("/prescricoes")
public class ControladorPrescricao {

    private RepositorioPrescricao repositorioPrescricao;
    private RepositorioMedico repositorioMedico;
    private RepositorioPaciente repositorioPaciente;
    private RepositorioMedicamento repositorioMedicamento;
   
    @Autowired
    public ControladorPrescricao(
        RepositorioPrescricao repositorioPrescricao,
        RepositorioMedico repositorioMedico,
        RepositorioPaciente repositorioPaciente,
        RepositorioMedicamento repositorioMedicamento) {
        this.repositorioPrescricao = repositorioPrescricao;
        this.repositorioMedico = repositorioMedico;
        this.repositorioPaciente = repositorioPaciente;
        this.repositorioMedicamento = repositorioMedicamento;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Prescricao getJSONPrescricao(@PathVariable("id") Long id) {
        Prescricao prescricao = repositorioPrescricao.findById(id);
        return prescricao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String medicamentos(Model model) {
        List<Prescricao> prescricoes = repositorioPrescricao.findAll();
        if (prescricoes != null) {
            model.addAttribute("prescricoes", prescricoes);
        }

        List<Medico> medicos = repositorioMedico.findAll();
        if (medicos != null) {
            model.addAttribute("medicos", medicos);
        }

        List<Paciente> pacientes = repositorioPaciente.findAll();
        if (pacientes != null) {
            model.addAttribute("pacientes", pacientes);
        }

        List<Medicamento> medicamentos = repositorioMedicamento.findAll();
        if (pacientes != null) {
            model.addAttribute("medicamentos", medicamentos);
        }

        return "prescricoes";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addPrescricao(
        @RequestParam(value="medico_id", defaultValue="0") long medico_id,
        @RequestParam(value="paciente_id", defaultValue="0") long paciente_id,
        @RequestParam(value="medicamentos") String medicamentos_id, 
        @RequestParam(value="data", defaultValue="NoData") String data,
        Prescricao prescricao) {

        Medico medico = repositorioMedico.findById(medico_id);
        Paciente paciente = repositorioPaciente.findById(paciente_id);
        
        Set<Medicamento> medicamentos = new HashSet<Medicamento>();;
        String[] parts = {};
        if (data != "NoData") {
            parts = medicamentos_id.split(",");
        }
        for (int i = 0; i < parts.length; i++){
            Medicamento medicamento = repositorioMedicamento.findById(Long.parseLong(parts[i]));
            medicamentos.add(medicamento);
        }

        prescricao.setMedico(medico);
        prescricao.setPaciente(paciente);
        prescricao.setMedicamentos(medicamentos);
        prescricao.setData(data);
        repositorioPrescricao.save(prescricao);

        return "redirect:/prescricoes";
    }
    
}

