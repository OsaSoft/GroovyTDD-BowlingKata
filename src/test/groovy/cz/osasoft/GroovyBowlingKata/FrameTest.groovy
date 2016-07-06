package cz.osasoft.GroovyBowlingKata

import spock.lang.Specification
import spock.lang.Unroll

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

    def "Set rolls when first is strike"(){
        when:
            f.firstRoll = 10
            f.secondRoll = 2
        then:
            thrown IllegalStateException
    }

    @Unroll
    def "Set rolls with more pins than bowling has"(){
        when:
            f.firstRoll = first
            f.secondRoll = second
        then:
            thrown IllegalStateException

        where:
            first << [11, 0, 4, 8]
            second << [0, 11, 7, 5]
    }

    @Unroll
    def "Get frame sum"(){
        when:
            f.firstRoll = first
            f.secondRoll = second
        then:
            f.frameRollSum == sum

        where:
            first << [1, 5, 7]
            second << [8, 3, 3]
            sum << [9, 8, 10]
    }
}
