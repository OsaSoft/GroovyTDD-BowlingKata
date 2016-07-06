package cz.osasoft.GroovyBowlingKata

/**
 * Created by OsaSoft on 06/07/16.
 */
class Game{
    def rolls = [].withDefault {0}
    def currentRoll = 0

    def roll(pins){
        if(currentRoll > 19) throw new IllegalStateException("Too many rolls")

        rolls[currentRoll++] = pins
    }

    def getScore(){
        def score = 0
        def frame = 0

        10.times{
            score += frameSum(frame) + bonus(frame)
            frame += isStrike(frame) ? 1 : 2
        }

        score
    }

    private bonus(frame){
        isSpare(frame) || isStrike(frame) ? rolls[frame + 2] : 0
    }

    private isSpare(frame){
        frameSum(frame) == 10
    }

    private isStrike(frame){
        rolls[frame] == 10
    }

    private frameSum(frame){
        rolls[frame] + rolls[frame+1]
    }
}