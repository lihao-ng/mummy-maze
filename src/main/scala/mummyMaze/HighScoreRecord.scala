package mummyMaze

import scalafx.beans.property.{StringProperty, ObjectProperty}

class HighScoreRecord(_playerName:String, _score:Score) {
  var playerName = new StringProperty(_playerName)
  var score = ObjectProperty(_score)
}

case class Score(v: ObjectProperty[Int]) {
  def this(k: Int){ this(ObjectProperty(k))}
}
