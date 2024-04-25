package App.Application.Controllers;

import App.Domain.Attraction;
import App.Domain.Rider;
import App.Infrastructure.AttractionRepository;
import App.Infrastructure.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Attraction")
public class AttractionController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private AttractionRepository attractionRepository;

    public AttractionController(){
        this.attractionRepository = new AttractionRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Attraction> get(){
        this.attractionRepository.setDatabaseConnection(this.databaseConnection);
        return this.attractionRepository.get();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Attraction> get(@PathVariable("name") String name){
        this.attractionRepository.setDatabaseConnection(this.databaseConnection);
        return this.attractionRepository.get(name);
    }
}
