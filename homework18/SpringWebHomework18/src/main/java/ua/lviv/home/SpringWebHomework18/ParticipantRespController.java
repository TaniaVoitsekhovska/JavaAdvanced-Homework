package ua.lviv.home.SpringWebHomework18;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/participants")
public class ParticipantRespController {
    @GetMapping("/")
    public String allParticipants() {
        return "index";
    }
}
