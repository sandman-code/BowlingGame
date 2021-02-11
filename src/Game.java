public class Game {
    int score = 0;
    int currRoll = 0;
    int[] rolls = new int[21]; //two rolls in each frame, plus an extra if strike;


    public void roll(int downPins)
    {
        if(downPins <= 10) {
            currRoll++;
            rolls[currRoll] = downPins;
        }
        else {
            currRoll++;
            rolls[currRoll] = 0;
        }
    }

    public int score()
    {
        int indexRoll = 0;
        for(int i = 0; i < 10; i++) //going through 10 frames
        {
            if(checkSpare(rolls[i]))
            {
                score += rolls[indexRoll] + rolls[indexRoll+1] + rolls[indexRoll+2];
                indexRoll+=2;
            }
            else if (checkStrike(rolls[i]))
            {
                score += rolls[indexRoll] + rolls[indexRoll+1] + rolls[indexRoll+2] + rolls[indexRoll+3];
                indexRoll++;
            }
            else {
                score += rolls[indexRoll] + rolls [indexRoll+1];
                indexRoll+=2;
            }

        }
        return score;
    }

    private boolean checkSpare(int roll)
    {
        return rolls[roll] + rolls[roll + 1] == 10;
    }

    private boolean checkStrike(int roll)
    {
        return rolls[roll] == 10;
    }
}

