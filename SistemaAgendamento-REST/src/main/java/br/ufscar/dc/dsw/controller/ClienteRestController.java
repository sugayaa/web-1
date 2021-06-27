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

import br.ufscar.dc.dsw.service.spec.IClienteService;

@CrossOrigin
@RestController
public class ClienteRestController {

    @Autowired
    private IClienteService service;

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
    private void parse(Cliente cliente, JSONObject json) {

        Object id = json.get("id");
        if (id != null) {
            if (id instanceof Integer) {
                cliente.setId(((Integer) id).longValue());
            } else {
                cliente.setId((Long) id);
            }
        }

        cliente.setNome((String) json.get("nome"));
        cliente.setEmail((String) json.get("email"));
        cliente.setSenha((String) json.get("senha"));
        cliente.setCPF((String) json.get("cpf"));
        cliente.setPapel((String) json.get("papel"));

        //cliente specific
        cliente.setSexo((String) json.get("sexo"));
        cliente.setDataNascimento((String) json.get("dataNascimento"));
        cliente.setTelefone((String) json.get("telefone"));

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
        consulta.setCliente((String) map.get("cliente"));
        consulta.setProfissional((String) map.get("profissional"));

    }

    @GetMapping(path = "/clientes")
    public ResponseEntity<List<Cliente>> lista() {
        List<Cliente> lista = service.findAll();

        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping(path = "/clientes/{id}")
    public ResponseEntity<Cliente> lista(@PathVariable("id") long id) {
        Cliente cliente = service.findById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping(path = "/clientes/{id}/consultas")
    public ResponseEntity<List<Cliente>> listaDeConsultas(@PathVariable("id") long id) {
        // service.findById retorna cliente
        // cons_service.buscarTodos retorna todas as consultas de dado cliente
        List<Cliente> lista = cons_service.buscarTodos(service.findById(id));

        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }



    @PostMapping(path = "/clientes")
    @ResponseBody
    public ResponseEntity<Cliente> cria(@RequestBody JSONObject json) {
        try {
            if (isJSONValid(json.toString())) {
                Cliente cliente = new Cliente();
                parse(cliente, json);
                service.save(cliente);
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

    @PutMapping(path = "/clientes/{id}")
    public ResponseEntity<Cliente> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
        try {
            if (isJSONValid(json.toString())) {
                cliente cliente = service.findById(id);
                if (cliente == null) {
                    return ResponseEntity.notFound().build();
                } else {
                    parse(cliente, json);
                    service.save(cliente);
                    return ResponseEntity.ok(cliente);
                }
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

    @DeleteMapping(path = "/clientes/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

        Cliente cliente = service.findById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
}
