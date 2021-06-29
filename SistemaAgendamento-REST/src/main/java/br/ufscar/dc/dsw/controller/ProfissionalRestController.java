package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Consulta;

import br.ufscar.dc.dsw.service.spec.IProfissionalService;
import br.ufscar.dc.dsw.service.spec.IConsultaService;

@CrossOrigin
@RestController
public class ProfissionalRestController {

    @Autowired
    private IProfissionalService service;

    @Autowired
    private IConsultaService cons_service;

    private boolean isJSONValid(String jsonInString) {
        try {
            return new ObjectMapper().readTree(jsonInString) != null;
        } catch (IOException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private void parse(Profissional profissional, JSONObject json) {

        Object id = json.get("id");
        if (id != null) {
            if (id instanceof Integer) {
                profissional.setId(((Integer) id).longValue());
            } else {
                profissional.setId((Long) id);
            }
        }

        profissional.setNome((String) json.get("nome"));
        profissional.setEmail((String) json.get("email"));
        profissional.setSenha((String) json.get("senha"));
        profissional.setCPF((String) json.get("cpf"));
        profissional.setPapel((String) json.get("papel"));

        //profissional specific
        profissional.setEspecialidade((String) json.get("especialidade"));

    }

    @SuppressWarnings("unchecked")
    private void parse(Consulta consulta, JSONObject json) {
        Map<String, Object> map = (Map<String, Object>) json.get("consulta");

        Object id = map.get("id");
        if (id instanceof Integer) {
            consulta.setId(((Integer) id).longValue());
        } else {
            consulta.setId((Long) id);
        }

        consulta.setData((String) map.get("data"));
        consulta.setHorario((String) map.get("horario"));
        consulta.setUrl((String) map.get("url"));
        consulta.setCliente((Cliente) map.get("cliente"));
        consulta.setProfissional((Profissional) map.get("profissional"));

    }

    @GetMapping(path = "/profissionais")
    public ResponseEntity<List<Profissional>> lista() {
        List<Profissional> lista = service.buscarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping(path = "/profissionais/{id}")
    public ResponseEntity<Profissional> lista(@PathVariable("id") long id) {
        Profissional profissional = service.buscarPorId(id);
        if (profissional == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profissional);
    }

    @GetMapping(path = "/consultas/profissionais/{id}")
    public ResponseEntity<List<Consulta>> listaDeConsultas(@PathVariable("id") long id) {
        List<Consulta> lista = cons_service.buscarTodos(service.buscarPorId(id));

        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }



    @PostMapping(path = "/profissionais")
    @ResponseBody
    public ResponseEntity<Profissional> cria(@RequestBody JSONObject json) {
        try {
            if (isJSONValid(json.toString())) {
                Profissional profissional = new Profissional();
                parse(profissional, json);
                service.salvar(profissional);
                return ResponseEntity.ok(profissional);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

    @PutMapping(path = "/profissionais/{id}")
    public ResponseEntity<Profissional> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
        try {
            if (isJSONValid(json.toString())) {
                Profissional profissional = service.buscarPorId(id);
                if (profissional == null) {
                    return ResponseEntity.notFound().build();
                } else {
                    parse(profissional, json);
                    service.salvar(profissional);
                    return ResponseEntity.ok(profissional);
                }
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

    @DeleteMapping(path = "/profissionais/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

        Profissional profissional = service.buscarPorId(id);
        if (profissional == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        }
    }
}
