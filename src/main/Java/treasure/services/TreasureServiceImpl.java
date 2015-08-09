package treasure.services;

import org.springframework.stereotype.Service;
import treasure.web.UserTreasureHuntCollection;

@Service
public class TreasureServiceImpl implements TreasureService {

    @Override
    public UserTreasureHuntCollection getTreasureHuntsByUserId(int userId) {
        return new UserTreasureHuntCollection();
    }

    @Override
    public UserTreasureHuntCollection getTrendingHunts(int numberOfHunts) {
        return new UserTreasureHuntCollection();
    }
}
