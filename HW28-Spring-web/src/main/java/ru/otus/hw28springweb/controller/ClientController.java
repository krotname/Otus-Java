package ru.otus.hw28springweb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.otus.hw28springweb.entity.Address;
import ru.otus.hw28springweb.entity.Client;
import ru.otus.hw28springweb.model.FrontClient;
import ru.otus.hw28springweb.repository.ClientRepository;

import java.util.Map;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ClientRepository clientRepository;

    @GetMapping("/")
    public String get(Model model) {
        log.info(String.valueOf(model));
        model.addAllAttributes(Map.of("clients", clientRepository.findAll()));
        return "clients";
    }

    @PostMapping("/addclient")
    public String addUser(FrontClient frontClient, BindingResult result) {
        log.info(String.valueOf(frontClient));
        if (result.hasErrors()) {
            return "clients";
        }

        Client client = Client.builder()
                .name(frontClient.getName())
                .addresses(Set.of(Address.builder()
                        .street(frontClient.getStreet())
                        .build()))
                .build();

        clientRepository.save(client);
        return "redirect:/";
    }
}
