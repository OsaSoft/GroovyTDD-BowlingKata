package cz.osasoft.GroovyBowlingKata

import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by OsaSoft on 06/07/16.
 */

class GameTest extends Specification {
    Game g

    def setup(){
        g = new Game()
    }

    def cleanup(){}

    def rollMany(n, pins){
        n.times{g.roll(pins)}
    }

    def "Test gutter game"(){
        when:
            rollMany(20, 0)
        then:
            g.score == 0
    }

    def "Test all ones"(){
        when:
            rollMany(20, 1)
        then:
            g.score == 20
    }

    def "Test one spare"(){
        when:
            g.roll(5)
            g.roll(5) //spare
            g.roll(3)
            rollMany(17, 0)
        then:
            g.score == 16
    }
}
