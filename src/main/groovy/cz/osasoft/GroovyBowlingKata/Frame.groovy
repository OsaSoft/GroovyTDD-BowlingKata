package cz.osasoft.GroovyBowlingKata

/**
 * Created by OsaSoft on 06/07/16.
 */
class Frame {
    def rolls = new int[2]

    def getFirstRoll(){
        rolls[0]
    }

    def setFirstRoll(pins){
        rolls[0] = pins
    }

    def getSecondRoll(){
        rolls[1]
    }

    def setSecondRoll(pins){
        rolls[1] = pins
    }
}
