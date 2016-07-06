package cz.osasoft.GroovyBowlingKata

/**
 * Created by OsaSoft on 06/07/16.
 */
class Game{
    def frames = [].withDefault {new Frame()}
    def currentFrame = 0
    def currentRoll = 0

    def roll(pins){
        if(currentRoll > 19) throw new IllegalStateException("Too many rolls")

        if(currentRoll++ % 2 == 0){
            frames[currentFrame].firstRoll = pins
        } else {
            frames[currentFrame].secondRoll = pins
            currentFrame++
        }
    }

    def getScore(){
        def score = 0

        frames.eachWithIndex{ frame, index ->
            score += frameSum(frame)
        }

//        10.times{
//            score += frameSum(frame) + bonus(frame)
//            frame += isStrike(frame) ? 1 : 2
//        }

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
        frame.frameRollSum
    }
}