package Maps

import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import java.io.File

import scalafx.scene.image.{Image, ImageView}


object Level1 {
  val outerWall1 = Rectangle (700.0, 35.0)
  outerWall1.fill = Color.rgb(216, 155, 49)

  val outerWall2 = Rectangle (0.0, 665.0, 700.0, 35.0)
  outerWall2.fill = Color.rgb(216, 155, 49)

  val outerWall3 = Rectangle (35.0, 598.0)
  outerWall3.fill = Color.rgb(216, 155, 49)

  val outerWall4 = Rectangle (665.0, 0.0, 35.0, 700.0)
  outerWall4.fill = Color.rgb(216, 155, 49)

  val wall1 = Rectangle (152.0, 35.0, 35.0, 100.0)
  wall1.fill = Color.rgb(216, 155, 49)

  val wall2 = Rectangle (475.0, 35.0, 35.0, 100.0)
  wall2.fill = Color.rgb(216, 155, 49)

  val wall3 = Rectangle (276.0, 100.0, 200.0, 35.0)
  wall3.fill = Color.rgb(216, 155, 49)

  val wall4 = Rectangle (35.0, 218.0, 394.0, 35.0)
  wall4.fill = Color.rgb(216, 155, 49)

  val wall5 = Rectangle (151.0, 253.0, 35.0, 100.0)
  wall5.fill = Color.rgb(216, 155, 49)

  val wall6 = Rectangle (394.0, 253.0, 35.0, 100.0)
  wall6.fill = Color.rgb(216, 155, 49)

  val wall7 = Rectangle (301.0, 353.0, 269.0, 35.0)
  wall7.fill = Color.rgb(216, 155, 49)

  val wall8 = Rectangle (35.0, 457.0, 269.0, 35.0)
  wall8.fill = Color.rgb(216, 155, 49)

  val wall9 = Rectangle (151.0, 492.0, 35.0, 100.0)
  wall9.fill = Color.rgb(216, 155, 49)

  val wall10 = Rectangle (533.0, 457.0, 35.0, 207.0)
  wall10.fill = Color.rgb(216, 155, 49)

  val wall11 = Rectangle (412.0, 457.0, 122.0, 35.0)
  wall11.fill = Color.rgb(216, 155, 49)

  val img = new Image(new File("src/main/background.jpg").toURI.toURL.toString)

  val walls = List(
    wall1,
    wall2,
    wall3,
    wall4,
    wall5,
    wall6,
    wall7,
    wall8,
    wall9,
    wall10,
    wall11,
    outerWall1,
    outerWall2,
    outerWall3,
    outerWall4
  )
}
