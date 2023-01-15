// Protractor.scala

object Solution {
    def solution(angle: Int): Int = {
       (if (angle <= 90) 1 else 3) + (if(angle % 90 == 0) 1 else 0)
    }
}