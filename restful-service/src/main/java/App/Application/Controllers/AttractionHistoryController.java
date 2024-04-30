package App.Application.Controllers;

import App.Domain.AttractionHistory;
import App.Infrastructure.AttractionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/AttractionHistory")
public class AttractionHistoryController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private AttractionHistoryRepository attractionHistoryRepository;

    public AttractionHistoryController(){
        this.attractionHistoryRepository = new AttractionHistoryRepository();
    }

    @GetMapping("/")
    public List<App.Domain.AttractionHistory> Get(){
        this.attractionHistoryRepository.setDatabaseConnection(databaseConnection);
        return this.attractionHistoryRepository.get();
    }

    @GetMapping("/{id}")
    public AttractionHistory Get(@PathVariable("id") String id){
        this.attractionHistoryRepository.setDatabaseConnection(databaseConnection);
        return this.attractionHistoryRepository.get(id).get(0);
    }
}
