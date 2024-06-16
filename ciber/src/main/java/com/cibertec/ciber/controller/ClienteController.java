package com.cibertec.ciber.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.ciber.entity.Cliente;
import com.cibertec.ciber.service.ClienteService;

@RestController
@RequestMapping("/url/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/listarClienteTodos")
    public List<Cliente> listaTodos() {
        return service.listaTodos();
    }

    @PostMapping("/registraCliente")
    @ResponseBody
    public ResponseEntity<?> inserta(@RequestBody Cliente obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Cliente objSalida = service.agregarActualizarCliente(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error al registrar");
            } else {
                salida.put("mensaje", "Registro exitoso");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error al registrar");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizaCliente")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaEjemplo(@RequestBody Cliente obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Cliente objSalida = service.agregarActualizarCliente(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error al actualiza");
            } else {
                salida.put("mensaje", "Actualización existosa exitoso");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error al actualiza");
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminaCliente/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaEjemplo(@PathVariable("id") int idEjemplo) {
        Map<String, Object> salida = new HashMap<>();
        try {
            service.eliminarCliente(idEjemplo);
            salida.put("mensaje", "Eliminación exitosa");
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }

}
