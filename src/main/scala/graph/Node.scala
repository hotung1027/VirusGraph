package graph

import math.min

class Node( val location : String, var nearbyArea : List[Node], var speed : Double, var population : Double, var infected : Double, var contact : Double, var mobility : Double, val r0f : (Double, Double, Double) => Double, var prob : Double ) {
  /*
    Spread Rate
 */
  
  def r0 : Double = r0f(mobility, contact, prob)
  
  def infect( node : Node ) : Unit = {
    node.infected = min(node.infected + infected * r0 * speed, node.population)
  }
  
  def connect( node : Node ) : Unit = {
    nearbyArea = nearbyArea.appended(node)
  }
  
  def spread( ) : Unit = {
    infect(this)
    for {node ← nearbyArea} {
      infect(node)
    }
  }
  
  def show( ) : Unit = println(s"${ location } has ${ infected } infected, in ${ infected / population } % residents in the area contaminated")
  
  
}
