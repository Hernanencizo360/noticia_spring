package com.egg.News.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Hernan
 */
@Entity
public class Noticia implements Serializable {
    
    // Atributos

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String titulo;
    @Column(columnDefinition="TEXT")
    private String cuerpo;
    private String imagen;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date alta;

    
    // Constructores
    public Noticia() {
    }

    public Noticia(String id, String titulo, String cuerpo, String imagen, Date alta) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.imagen = imagen;
        this.alta = alta;
    }
  
    // Metodos Getter y Setter

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
//    public void setId(String id) {
//        this.id = id;
//    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the alta
     */
    public Date getAlta() {
        return alta;
    }

    /**
     * @param alta the alta to set
     */
    public void setAlta(Date alta) {
        this.alta = alta;
    }
    
    
}
