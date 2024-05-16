package es.uah.peliculas.controller;


import es.uah.peliculas.model.Pelicula;
import es.uah.peliculas.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/home")
public class VistasController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "http://localhost:8001/peliculas";
    private IPeliculasService peliculasService;


    @GetMapping("/listaPeliculas")
    public String listadoPeliculas(Model model) {
            Pelicula[] peliculas = restTemplate.getForObject(API_URL, Pelicula[].class);
            model.addAttribute("peliculas", peliculas);
        return "home";
    }


}
