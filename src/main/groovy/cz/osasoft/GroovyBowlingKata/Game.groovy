package cz.osasoft.GroovyBowlingKata

/**
 * Created by OsaSoft on 06/07/16.
 */
class Game{
    def frames = [].withDefault {new Frame()}
    def currentFrame = 0
    def currentRoll = 0

    def roll(pins){
        if(isTooManyRolls()) throw new IllegalStateException("Too many rolls")

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

        (0..9).each{ frameIndex ->
            def frame = frames[frameIndex]
            score += frame.frameRollSum + bonus(frame, frameIndex)
        }

        score
    }

    private bonus(frame, index){
        if(index == 11) return 0

        if(frame.isSpare()){
            return frames[index+1].firstRoll
        }

        if(frame.isStrike()){
            if(frames[index+1].isStrike()){
                return 10 + frames[index+2].frameRollSum
            } else {
                return frames[index+1].frameRollSum
            }
        }

        return 0
    }
    
    private isTooManyRolls(){
        frames.size() == 12 || 
                (frames.size() >= 10 && (currentRoll % 2 == 0) && !frames[currentFrame-1].isStrike())
    }
}