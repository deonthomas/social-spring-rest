package treasure.services;

import treasure.web.UserTreasureHuntCollection;

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
