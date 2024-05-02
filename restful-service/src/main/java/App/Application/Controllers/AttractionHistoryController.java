package App.Application.Controllers;

import App.Domain.AttractionHistory;
import App.Infrastructure.AttractionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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
    public List<App.Domain.AttractionHistory> get(){
        this.attractionHistoryRepository.setDatabaseConnection(databaseConnection);
        return this.attractionHistoryRepository.get();
    }

    @GetMapping("/{id}")
    public List<AttractionHistory> get(@PathVariable("id") String id){
        this.attractionHistoryRepository.setDatabaseConnection(databaseConnection);
        return this.attractionHistoryRepository.get(id);
    }

    @PostMapping("/")
    public String post(@RequestBody() AttractionHistory historyToSave){
        this.attractionHistoryRepository.setDatabaseConnection(databaseConnection);
        this.attractionHistoryRepository.create(historyToSave);
        return historyToSave.getAttractionName();
    }

    @PutMapping("/{attractionName}/{historyDate}")
    public void put(@RequestBody() AttractionHistory historyToUpdate,
                    @PathVariable("attractionName") String attractionName,
                    @PathVariable("historyDate") String historyDate){
        this.attractionHistoryRepository.setDatabaseConnection(databaseConnection);
        this.attractionHistoryRepository.update(attractionName, historyDate, historyToUpdate);
    }

    @DeleteMapping("/{attractionName}/{historyDate}")
    public void delete(@PathVariable("attractionName") String attractionName,
                       @PathVariable("historyDate") String historyDate){
        this.attractionHistoryRepository.setDatabaseConnection(databaseConnection);
        this.attractionHistoryRepository.delete(attractionName, historyDate);
    }
}
