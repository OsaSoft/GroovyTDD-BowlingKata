package cz.osasoft.GroovyBowlingKata

/**
 * Created by OsaSoft on 06/07/16.
 */
class Game{
    def rolls = [].withDefault {0}
    def currentRoll = 0

    def roll(pins){
        rolls[currentRoll++] = pins
    }

    def getScore(){
        def score = 0
        def frame = 0

        10.times{
            score += rolls[frame] + rolls[frame+1]

            if(isSpare(frame) || rolls[frame] == 10){ //spare or strike
                score += rolls[frame + 2]
            }

            frame += rolls[frame] == 10 ? 1 : 2 //strike
        }

        score
    }

    private isSpare(int frame){
        rolls[frame] + rolls[frame+1] == 10
    }
}