package com.egg.News.controladores;

import com.egg.News.entidades.Noticia;
import com.egg.News.excepciones.MiException;
import com.egg.News.servicios.NoticiaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Hernan
 */
@Controller
public class NoticiaControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping("/") // especificamos la ruta donde interactua el usuario
    public String inicio(Model model) {
        try {
            List<Noticia> noticias = noticiaServicio.listarNoticias(); // buscar todas las noticias
            model.addAttribute("noticias", noticias); // agregamos al model la propiedad "noticias" y la variable

            return "index"; // indicamos el path de nuestra pagina. Vamos a templates a crearla.
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error"; // mas tarde crearemos un html para mostrar si surge errores
        }
    }

    @GetMapping("/detalle/{id}")
    public String detalleNoticia(Model model, @PathVariable("id") String id) {
        try {
            Noticia noticia = noticiaServicio.buscarNoticia(id);
            model.addAttribute("noticia", noticia);
            return "detalle";

        } catch (MiException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
