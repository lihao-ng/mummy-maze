package mummyMaze.Components

import scalafx.beans.property.ObjectProperty

case class Score(v: ObjectProperty[Int]) {
  def this(k: Int){ this(ObjectProperty(k))}
}