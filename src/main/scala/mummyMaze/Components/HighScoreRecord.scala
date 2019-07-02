package mummyMaze.Components

import Database.Database
import scalafx.beans.property.{ObjectProperty, StringProperty}
import scalikejdbc._

import scala.util.Try

class HighScoreRecord(_playerName: String, _score: Score) extends Database {
  var playerName = new StringProperty(_playerName)
  var score = ObjectProperty(_score)

  def save() : Any = {
      Try(DB autoCommit { implicit session =>
        sql"""
					insert into highScoreRecord (playerName, score) values
						(${playerName.value}, ${score.value.v.value})
				""".update.apply()
      })
  }

  def delete() : Try[Int] = {
      Try(DB autoCommit { implicit session =>
        sql"""
				delete from highScoreRecord where
					playerName = ${playerName.value} and score = ${score.value.v.value}
				""".update.apply()
      })
  }
}

object HighScoreRecord extends Database{
  def apply (
              playerNameS : String,
              scoreS : Score
            ) : HighScoreRecord = {

    new HighScoreRecord(playerNameS, scoreS)

  }
  def initializeTable() = {
    DB autoCommit { implicit session =>
      sql"""
			create table highScoreRecord (
			  id int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
			  playerName varchar(64),
			  score int
			)
			""".execute.apply()
    }
  }

  def getAllRecord : List[HighScoreRecord] = {
    DB readOnly { implicit session =>
    sql"select * from highScoreRecord".map(rs => HighScoreRecord(rs.string("playerName"),new Score(rs.int("score")))).list.apply()
    }
  }
}
