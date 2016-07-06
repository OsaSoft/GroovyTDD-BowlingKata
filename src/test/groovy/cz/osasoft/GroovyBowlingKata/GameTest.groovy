package cz.osasoft.GroovyBowlingKata

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

    def "Test gutter game"(){
        when:
            20.times{
                g.roll(0)
            }
        then:
            g.score == 0
    }

    def "Test all ones"(){
        when:
            20.times{
                g.roll(1)
            }
        then:
            g.score == 20
    }
}
