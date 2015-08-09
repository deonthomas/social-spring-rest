package treasure.services;

import treasure.web.UserTreasureHuntCollection;

public interface TreasureService {
    UserTreasureHuntCollection getTreasureHuntsByUserId(int userId);

    UserTreasureHuntCollection getTrendingHunts(int numberOfHunts);
}

