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

            if(frames[currentFrame].isStrike()){
                currentFrame++
                currentRoll++
            }
        } else {
            frames[currentFrame].secondRoll = pins
            currentFrame++
        }
    }

    def getScore(){
        def score = 0

        frames.eachWithIndex{ frame, index ->
            score += frame.frameRollSum + bonus(frame, index)
        }

        score
    }

    private bonus(frame, index){
        if(frame.isSpare()){
            return frames[index+1].firstRoll
        }

        if(frame.isStrike()){
            return frames[index+1].frameRollSum
        }

        return 0
    }
}