package com.proyecto.transporte.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.proyecto.transporte.dao.DestinoRepository;
import com.proyecto.transporte.entidad.Destino;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository repo;

    @Value("${app.ruta.imagenes}")
    private String rutaImagenes;

    public List<Destino> listarTodos() {
        return repo.findAll();
    }

    public Destino registrar(Destino d) {
        return repo.save(d);
    }

    public Destino findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Destino guardarConImagen(String nombre, MultipartFile imagen) throws IOException {
        String rutaImagen = guardarArchivo(imagen);

        Destino destino = new Destino();
        destino.setNombre(nombre);
        destino.setImagen(rutaImagen);

        return repo.save(destino);
    }

    public Destino editarConImagen(Integer id, String nombre, MultipartFile imagen) throws IOException {
        Destino destino = repo.findById(id).orElseThrow(() -> new RuntimeException("Destino no encontrado"));

        destino.setNombre(nombre);

        if (imagen != null && !imagen.isEmpty()) {
            String rutaImagen = guardarArchivo(imagen);
            destino.setImagen(rutaImagen);
        }

        return repo.save(destino);
    }

    public void eliminar(Integer id) {
        Destino destino = repo.findById(id).orElseThrow(() -> new RuntimeException("Destino no encontrado"));
        if (destino.getImagen() != null) {
            eliminarArchivo(destino.getImagen());
        }
        repo.deleteById(id);
    }

    private String guardarArchivo(MultipartFile archivo) throws IOException {
        if (archivo == null || archivo.isEmpty() || !esImagenValida(archivo)) {
            return null;
        }

        File directorio = new File(rutaImagenes);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        String nombreArchivo = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();
        Path rutaArchivo = Paths.get(rutaImagenes + nombreArchivo);
        Files.write(rutaArchivo, archivo.getBytes());

        return rutaArchivo.toString();
    }

    private boolean esImagenValida(MultipartFile archivo) {
        String tipo = archivo.getContentType();
        return tipo.equals("image/jpeg") || tipo.equals("image/png");
    }

    private void eliminarArchivo(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            archivo.delete(); 
        }
    }
}