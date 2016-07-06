package cz.osasoft.GroovyBowlingKata

import spock.lang.Specification

/**
 * Created by oscar on 06/07/16.
 */
class FrameTest extends Specification {
    Frame f

    def setup(){
        f = new Frame()
    }

    def cleanup(){}

    def "Set rolls"(){
        when:
            f.firstRoll = 3
            f.secondRoll= 2
        then:
            f.firstRoll == 3
            f.secondRoll == 2
    }
}
