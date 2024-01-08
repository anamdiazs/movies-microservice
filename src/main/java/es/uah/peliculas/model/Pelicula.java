package es.uah.peliculas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Peliculas", schema = "peliculasdb")
public class Pelicula {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPeliculas")
    private Integer idPeliculas;
    @Basic
    @Column(name = "titulo")
    private String titulo;
    @Basic
    @Column(name = "year")
    private Integer year;
    @Basic
    @Column(name = "duracion")
    private Integer duracion;
    @Basic
    @Column(name = "pais")
    private String pais;
    @Basic
    @Column(name = "genero")
    private String genero;
    @Basic
    @Column(name = "sinopsis")
    private String sinopsis;
    @Getter
    @Lob
    @Column(name = "portada", columnDefinition = "BLOB")

    private transient ByteArrayInputStream portada;
    private byte[] portadaBytes; // new field to store the byte array

    // Other methods...

    public byte[] getPortadaBytes() {
        return portadaBytes;
    }

    public void setPortadaBytes(byte[] portadaBytes) {
        this.portadaBytes = portadaBytes;
    }

    // Method to convert portada ByteArrayInputStream to byte array
    public byte[] getPortadaAsByteArray() {
        if (portada != null) {
            return portada.readAllBytes();
        }
        return null; // or an empty byte array, depending on your requirements
    }
    @ManyToMany(mappedBy = "peliculas", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("peliculas")
    private List<Actor> actores;

    public Integer getIdPelicula() {
        return idPeliculas;
    }
    public void setIdPelicula(Integer idPelicula) {
        this.idPeliculas = idPelicula;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setPortadaAsByteArray(byte[] portada) {
        if (portada != null) {
            this.portada = new ByteArrayInputStream(portada);
        }
    }


    public void addActor(Actor actor){
        if(actor != null){
            getActores().add(actor);
        }
    }
    public void removeActor(Actor actor){
        if(actor != null){
            getActores().remove(actor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(idPeliculas, pelicula.idPeliculas) && Objects.equals(titulo, pelicula.titulo) && Objects.equals(year, pelicula.year) && Objects.equals(duracion, pelicula.duracion) && Objects.equals(pais, pelicula.pais) && Objects.equals(genero, pelicula.genero) && Objects.equals(sinopsis, pelicula.sinopsis) && Objects.equals(portada, pelicula.portada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeliculas, titulo, year, duracion, pais, genero, sinopsis, portada);
    }
}
