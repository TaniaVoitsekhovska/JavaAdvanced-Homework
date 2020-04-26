package ua.lviv.home.SpringWebHomework18.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ua.lviv.home.SpringWebHomework18.entities.Participant;
import ua.lviv.home.SpringWebHomework18.entities.ParticipantRequest;
import ua.lviv.home.SpringWebHomework18.services.ParticipantService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String allParticipants(HttpServletRequest request) {
        request.setAttribute("participants", participantService.findAll());
        request.setAttribute("mode", "PARTICIPANT_VIEW");
        return "participant";
    }

    @GetMapping("/new")
    public String newParticipant(HttpServletRequest request) {
        request.setAttribute("mode", "PARTICIPANT_CREATE");
        return "participant";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Participant participant, HttpServletRequest request) {
        participantService.save(participant);
        request.setAttribute("participants", participantService.findAll());
        request.setAttribute("mode", "PARTICIPANT_VIEW");
        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ParticipantRequest participantRequest, HttpServletRequest req) {
        participantService.save(participantRequest);
        req.setAttribute("participants", participantService.findAll());
        req.setAttribute("mode", "PARTICIPANT_VIEW");
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, HttpServletRequest request) {
        Optional<Participant> participant = participantService.findOne(id);

        if (participant.isPresent()) {
            request.setAttribute("participant", participant.get());
            request.setAttribute("mode", "PARTICIPANT_EDIT");
            return "participant";
        }
        return "participant does not exist";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam (name = "id") int id, HttpServletRequest request) {
        participantService.deleteById(id);
        request.setAttribute("participants", participantService.findAll());
        request.setAttribute("mode", "PARTICIPANT_VIEW");
        return "redirect:/";
    }
}
