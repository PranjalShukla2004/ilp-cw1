package project.ilp.PizzaDronz.run;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class RunController {

    private final RunRepo runrepo;
    public RunController(RunRepo runRepo) {
        this.runrepo = runRepo;
    }

    // End-Point 1
    @GetMapping("/uuid")
    String return_id(){
        return runrepo.uuid();
    }


    // End-Point 2
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/distanceTo")
    public ResponseEntity<Double> returnDistanceTo(@RequestBody LngLatPairRequest json) {
            // Call the service method to calculate distance
            ResponseEntity<Double> distance = runrepo.calculateDistance(json);
            return ResponseEntity.ok(distance.getBody()); // Return HTTP 200 with the distance
    }

    // End-point 3
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/isCloseTo")
    public ResponseEntity<Boolean> returnIsCloseTo(@RequestBody LngLatPairRequest json) {
        return runrepo.isCloseTo(json);

    }

    // End-point 4
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nextPosition")
    public ResponseEntity<Position> calNextPos(@RequestBody LngLatAngleRequest json) {
        return runrepo.nextPosition(json);

    }

    // End-point 5
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/isInRegion")
    public ResponseEntity<Boolean> validRegion(@RequestBody LngLatRegionRequest json) {
        return runrepo.isWithinRange(json);
    }


}
