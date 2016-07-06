package cz.osasoft.GroovyBowlingKata

import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by OsaSoft on 06/07/16.
 */

class GameTest extends Specification {
    static final STRIKE = 10

    Game g

    def setup(){
        g = new Game()
    }

    def cleanup(){}

    def rollMany(n, pins){
        n.times{g.roll(pins)}
    }

    def rollSpareTo(prevRoll){
        g.roll(10 - prevRoll)
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
            rollSpareTo(5)
            g.roll(3)
            rollMany(17, 0)
        then:
            g.score == 16
    }

    def "Test one strike"(){
        when:
            g.roll(STRIKE)
            g.roll(3)
            g.roll(4)
            rollMany(16, 0)
        then:
            g.score == 24
    }

    def "Test perfect game"(){
        when:
            rollMany(12, STRIKE)
        then:
            g.score == 300
    }
}
