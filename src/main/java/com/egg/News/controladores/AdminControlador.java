package com.egg.News.controladores;

import com.egg.News.entidades.Noticia;
import com.egg.News.excepciones.MiException;
import com.egg.News.servicios.NoticiaServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Hernan
 */
@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping("/crear") //localhost:8080/admin/crear
    public String crear() {

        return "noticiaFormulario";
    }

    @PostMapping("/creando")
    public String creando(@RequestParam String titulo, @RequestParam String cuerpo, @RequestParam String imagen, ModelMap modelo) {

        try {
            noticiaServicio.crearNoticia(titulo, cuerpo, imagen);

            modelo.put("exito", "La Noticia fue cargada con éxito.");

        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            return "noticiaFormulario";
        }
        // cambiar a noticiaFormulario
        return "index";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Noticia> noticias = noticiaServicio.listarNoticias();

        modelo.addAttribute("noticias", noticias);

        return "noticiaList.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo) {
        modelo.put("noticia", noticiaServicio.getOne(id));

        return "noticiaModificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String titulo, String cuerpo, String imagen, ModelMap modelo) {
        try {
            noticiaServicio.modificarNoticia(id, titulo, cuerpo, imagen);

           return "redirect:../lista";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "noticiaModificar.html";
        }

    }
}
