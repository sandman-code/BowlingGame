import org.junit.Test;
import org.junit.Assert;


public class Tests {
    // < 10
    @Test
    public void rollTest(){
        Game game = new Game();
        game.roll(0); //base case
        Assert.assertEquals(0, game.score());
        game.roll(8);
        game.roll(1); //normal case
        Assert.assertEquals(9, game.score());

        Game nGame = new Game();
        game.roll(11);
        Assert.assertEquals(0, nGame.score()); //any invalid scores will return 0
    }

    @Test
    public void spareTest()
    {
        Game game = new Game();
        game.roll(5);
        game.roll(5); //spare instance, end frame 1


        game.roll(3); //bonus for frame
        //score 5 + 5 + 3 = 13

        for(int i = 0; i < 17; i++) //go through the rest of the frames
        {
            game.roll(0);
        }
        Assert.assertEquals(13, game.score());
    }

    @Test
    public void strikeTest()
    {
        Game game = new Game();
        game.roll(10);
        //score 10 + 3 + 4 = 17

        game.roll(3); //bonus for frame
        game.roll(4); //bonus for frame

        for(int i = 0; i < 17; i++) //go through the rest of the frames
        {
            game.roll(0);
        }
        Assert.assertEquals(20, game.score());
    }

    @Test
    public void calcTest()
    {
        Game game = new Game();
        for(int i = 0; i < 10; i++)
        {
            game.roll(1);
        }
        Assert.assertEquals(10, game.score());
    }
}

