package App.Application.Controllers;

import App.Domain.Attraction;
import App.Domain.Rider;
import App.Domain.Ride;
import App.Infrastructure.AttractionRepository;
import App.Infrastructure.RideRepository;
import App.Infrastructure.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Ride")
public class RideController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private RideRepository rideRepository;

    private AttractionRepository attractionRepository;

    private RiderRepository riderRepository;

    public RideController(){
        this.rideRepository = new RideRepository();
        this.attractionRepository = new AttractionRepository();
        this.riderRepository = new RiderRepository();
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void post(@RequestBody() Ride ride) throws Exception {
        this.rideRepository.setDatabaseConnection(this.databaseConnection);
        this.attractionRepository.setDatabaseConnection(this.databaseConnection);
        this.riderRepository.setDatabaseConnection(this.databaseConnection);

        try{
            List<Attraction> attractions = this.attractionRepository.get(ride.getAttractionName());
            if (attractions.isEmpty()){
                throw new Exception("No attraction found with name " + ride.getAttractionName());
            }

            Attraction attraction = attractions.get(0);

            List<Rider> riders = this.riderRepository.get(ride.getRiderEmail());
            if (riders.isEmpty()){
                throw new Exception("No rider found with email " + ride.getRiderEmail());
            }

            Rider rider = riders.get(0);

            rider.ride(attraction);

            this.riderRepository.update(rider.getEmail(), rider);
            this.rideRepository.create(ride);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
