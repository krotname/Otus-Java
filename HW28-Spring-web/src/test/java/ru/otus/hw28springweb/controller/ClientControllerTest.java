package ru.otus.hw28springweb.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw28springweb.entity.Address;
import ru.otus.hw28springweb.entity.Client;
import ru.otus.hw28springweb.entity.Phone;
import ru.otus.hw28springweb.repository.ClientRepository;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    public void testGet() throws Exception {
        Client client = Client.builder().name("John").addresses(Set.of(Address.builder().street("Street").build())).build();
        when(clientRepository.findAll()).thenReturn(Collections.singletonList(client));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("clients"))
                .andExpect(model().attributeExists("clients"));

        verify(clientRepository, times(1)).findAll();
    }

    @Test
    public void testAddUser() throws Exception {
        String name = "John";
        String street = "Street";

        mockMvc.perform(post("/addclient")
                        .param("name", name)
                        .param("street", street))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    public void testGetNoClients() throws Exception {
        when(clientRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("clients"))
                .andExpect(model().attribute("clients", Collections.emptyList()));

        verify(clientRepository, times(1)).findAll();
    }

    @Test
    public void testGetClients() throws Exception {
        List<Client> clients = List.of(new Client(1L, "John",
                Set.of(Address.builder().street("Street").build()),
                Set.of(new Phone(1L, 1L, "89996325665"))));
        when(clientRepository.findAll()).thenReturn(clients);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("clients"))
                .andExpect(model().attribute("clients", clients));

        verify(clientRepository, times(1)).findAll();
    }
}