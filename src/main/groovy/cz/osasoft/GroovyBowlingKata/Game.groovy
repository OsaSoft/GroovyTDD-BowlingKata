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
        def i = 0

        10.times{
            score += rolls[i] + rolls[i+1]
            i += 2
        }

        return score
    }
}