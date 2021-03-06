package cz.osasoft.GroovyBowlingKata

import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

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

    def getSpareTo(prevRoll){
        10 - prevRoll
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
            g.with{
                roll(5)
                roll(getSpareTo(5))
                roll(3)
            }
            rollMany(17, 0)
        then:
            g.score == 16
    }

    def "Test one strike"(){
        when:
        g.with{
            roll(STRIKE)
            roll(3)
            roll(4)
        }
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

    def "Test too many rolls"(){
        when:
            rollMany(21, 0)
        then:
            thrown IllegalStateException
    }

    def "Test too many strikes"(){
        when:
            rollMany(13, STRIKE)
        then:
            thrown IllegalStateException
    }

    def "Test 10th frame strike and next roll not"(){
        when:
            rollMany(10, STRIKE)
            g.with{
                roll(2)
                roll(5)
            }
        then:
            g.score == 279
    }

    def "Test 10th frame strike and next spare"(){
        when:
            rollMany(10, STRIKE)
            g.with{
                roll(2)
                roll(getSpareTo(2))
            }
        then:
            g.score == 282
    }

    @Unroll
    def "Test 10th frame spare and next normal or strike"(){
        when:
            rollMany(9, STRIKE)
            g.with{
                roll(2)
                roll(getSpareTo(2))
                roll(finalRoll)
            }
        then:
            g.score == score

        where:
            finalRoll << [3, STRIKE]
            score << [265, 272]
    }
}
