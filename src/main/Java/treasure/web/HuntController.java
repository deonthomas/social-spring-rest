package treasure.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import treasure.services.TreasureService;

@EnableAutoConfiguration
@RequestMapping(value = "/hunts", produces = "application/json")
@RestController
public class HuntController {

    private TreasureService treasureService;


    public HuntController(){

    }

    public HuntController(TreasureService treasureService) {

        this.treasureService = treasureService;
    }

    @ResponseBody
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserTreasureHuntCollection getTreasureHuntsByUserId(@PathVariable int userId) {
        return treasureService.getTreasureHuntsByUserId(userId);
    }

//    @ResponseBody
//    @RequestMapping(value="/", method = RequestMethod.GET)
//    public UserTreasureHunt[] getHunts() {
//        return new UserTreasureHunt[]{
//                new UserTreasureHunt("myTreasure", "This is the best treasure ever", "image"),
//                new UserTreasureHunt("myTreasure1", "This is the best treasure ever1", "image1"),
//                new UserTreasureHunt("myTreasure2", "This is the best treasure ever2", "image2")
//        };
//    }
//
//    @ResponseBody
//    @RequestMapping(value="/", method = RequestMethod.GET)
//    public UserTreasureHunt[] getHuntsByLocation(int longitude,int latitude ) {
//        return new UserTreasureHunt[]{
//                new UserTreasureHunt("myTreasure", "This is the best treasure ever", "image"),
//                new UserTreasureHunt("myTreasure1", "This is the best treasure ever1", "image1"),
//                new UserTreasureHunt("myTreasure2", "This is the best treasure ever2", "image2")
//        };
//    }
//
}