package com.cibertec.ciber.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.ciber.entity.Cliente;

public interface ClienteService {

    // METODO PARA EL CRUD DEL CLIENTE GAAA
    public abstract List<Cliente> listaTodos();

    public abstract Optional<Cliente> buscarClientePorId(int id);

    public abstract Cliente agregarActualizarCliente(Cliente cliente);

    public abstract void eliminarCliente(int id);

}
