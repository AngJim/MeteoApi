package com.meteoApi.ControlloTempo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meteoApi.ControlloTempo.model.Citta;
import com.meteoApi.ControlloTempo.repos.CittaRepository;
import com.meteoApi.ControlloTempo.service.MeteoService;

@Controller
public class MeteoController {
    @Autowired
    private CittaRepository cittaRepo;
    @Autowired
    private MeteoService meteoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cittaList", cittaRepo.findAll());
        return "index";
    }

    @PostMapping("/meteo")
    public String mostraMeteo(@RequestParam int idCitta, Model model) {
        Citta citta = cittaRepo.findById(idCitta).orElseThrow();
        String json = meteoService.getMeteoData(citta.getLatitudine(), citta.getLongitudine());
        model.addAttribute("json", json);
        return "grafico";
    }
}