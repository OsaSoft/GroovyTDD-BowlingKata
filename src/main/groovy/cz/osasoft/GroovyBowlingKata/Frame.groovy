package cz.osasoft.GroovyBowlingKata

/**
 * Created by OsaSoft on 06/07/16.
 */
class Frame {
    def rolls = [0,0] as Integer[]

    def getFirstRoll(){
        rolls[0]
    }

    def setFirstRoll(pins){
        if(pins > 10) throw new IllegalStateException()

        rolls[0] = pins
    }

    def getSecondRoll(){
        rolls[1]
    }

    def setSecondRoll(pins){
        if(firstRoll == 10 || firstRoll + pins > 10) throw new IllegalStateException()

        rolls[1] = pins
    }

    def getFrameRollSum(){
        rolls.sum()
    }

    def isSpare(){
        frameRollSum == 10 && firstRoll != 10
    }

    def isStrike(){
        firstRoll == 10
    }
}
