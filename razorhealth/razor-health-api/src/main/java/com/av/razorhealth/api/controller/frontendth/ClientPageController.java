package com.av.razorhealth.api.controller.frontendth;

import com.av.razorhealth.api.model.Client;
import com.av.razorhealth.api.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientPageController {

    private final ClientRepository clientRepository;

    public ClientPageController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Frontend page for listing clients
    @GetMapping("/clients")
    public String clientsPage(Model model) {
        List<Client> clients = clientRepository.findAll(); // get data from repo
        model.addAttribute("clients", clients);           // add to Thymeleaf model
        model.addAttribute("client", new Client());       // add empty client object for form
        return "client/client-list";                      // points to fe-th template
    }

    // Handle form submission to save client
    @PostMapping("/clients")
    public String saveClient(Client client) {
        clientRepository.save(client);
        return "redirect:/clients";                      // redirect to clients list page
    }
}
