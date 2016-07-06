package cz.osasoft.GroovyBowlingKata

/**
 * Created by OsaSoft on 06/07/16.
 */
class Game{
    def score = 0

    def roll(pins){
        score += pins
    }
}