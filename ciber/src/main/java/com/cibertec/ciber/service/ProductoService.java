package com.cibertec.ciber.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.ciber.entity.Producto;

public interface ProductoService {

    public abstract List<Producto> listarTodosProductos();

    public abstract Optional<Producto> buscarProductoPorId(int id);

    public abstract Producto agregarActualizarProducto(Producto producto);

    public abstract void eliminarProducto(int id);
}
