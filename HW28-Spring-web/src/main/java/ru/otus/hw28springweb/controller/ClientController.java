package ru.otus.hw28springweb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.otus.hw28springweb.controller.repository.ClientRepository;
import ru.otus.hw28springweb.model.Client;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;

    @GetMapping("/")
    public String get(Model model) {
//        Client client = new Client();
//        client.setId(1L);
//        client.setName("ыва");
//        model.addAllAttributes(Map.of("users", List.of(client, client)));
        model.addAllAttributes(Map.of("users",clientRepository.findAll()));
        return "clients";
    }

    @PostMapping("/addclient")
    public String addUser(@Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "clients";
        }

        clientRepository.save(client);
        return "redirect:/";
    }
}
