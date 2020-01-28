package virus

import math.{ exp }

class Virus( var gene : Double,
             var decay : Double,
             var survive : Double,
             var generation : Double,
             var level : Double
           ) {
  def evovle( ) : Unit = {
    if (gene % level * generation >= 0)
      level += 1
    else
      generation += gene / level
    gene += generation / level
  }
  
  def prob( time : Double ) : Double = level * survive * exp(-decay * time)
  
}
