package treasure.services;

import org.springframework.stereotype.Service;
import treasure.web.UserTreasureHuntCollection;

@Service
public interface TreasureService {
    UserTreasureHuntCollection getTreasureHuntsByUserId(int userId);

    UserTreasureHuntCollection getTrendingHunts(int numberOfHunts);
}

