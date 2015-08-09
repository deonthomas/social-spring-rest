package Controller.Tests;

import org.junit.Assert;
import treasure.services.TreasureService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import treasure.web.HuntController;
import treasure.web.UserTreasureHunt;
import treasure.web.UserTreasureHuntCollection;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


@RunWith(MockitoJUnitRunner.class)
public class HuntControllerTests{

    private static final int USER_ID = 1;
    private static final String NAME = "Name";
    private static final String DESCRIPTION = "Description";
    private static final String IMAGE_PATH = "ImagePath";
    private static final int NUMBER_OF_HUNTS = 10;
    private HuntController huntController;
    @Mock
    private TreasureService treasureService ;


    @Before
    public  void Setup()
    {
        initMocks(this);
    }

    @Test
    public void shouldGetUserTreasureHunts() {

        huntController = new HuntController(treasureService);

        UserTreasureHuntCollection returnedUserHUnts = new UserTreasureHuntCollection();
        returnedUserHUnts.add(new UserTreasureHunt(NAME, DESCRIPTION, IMAGE_PATH));

        when(treasureService.getTreasureHuntsByUserId(USER_ID)).thenReturn(returnedUserHUnts);

        UserTreasureHuntCollection userHUnts = huntController.getTreasureHuntsByUserId(USER_ID);
        Assert.assertEquals(returnedUserHUnts, userHUnts);
    }


    @Test
    public void shouldGetTrendingTreasureHunts() {

        huntController = new HuntController(treasureService);

        UserTreasureHuntCollection returnedUserHUnts = new UserTreasureHuntCollection();
        returnedUserHUnts.add(new UserTreasureHunt(NAME, DESCRIPTION, IMAGE_PATH));

        when(treasureService.getTrendingHunts(NUMBER_OF_HUNTS)).thenReturn(returnedUserHUnts);

        UserTreasureHuntCollection userHUnts = huntController.getTreasureHuntsByUserId(USER_ID);
        Assert.assertEquals(returnedUserHUnts, userHUnts);
    }


}