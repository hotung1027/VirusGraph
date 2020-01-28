package object graph {
  
  import math.{ max, min }
  
  def Box( Upper : Double, Lower : Double, value : Double ) : Double = min(max(value, Lower), Upper)
}
