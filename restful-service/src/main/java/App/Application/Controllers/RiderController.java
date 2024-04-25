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
@RequestMapping("/Rider")
public class RiderController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private RiderRepository riderRepository;

    public RiderController(){
        this.riderRepository = new RiderRepository();
    }
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Rider> get(){
        this.riderRepository.setDatabaseConnection(this.databaseConnection);
        return this.riderRepository.get();
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public List<Rider> get(@PathVariable("email") String email){
        this.riderRepository.setDatabaseConnection(this.databaseConnection);
        return this.riderRepository.get(email);
    }
}
