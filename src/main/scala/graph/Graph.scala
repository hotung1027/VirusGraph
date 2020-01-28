package graph

class Graph( var tstep : Double, var Nodes : List[Node] ) {
  var t = 0.0
  
  def network : Map[String, Node] = Nodes.map(node => (node.location, node)).toMap
  
  def spread( source : Node ) : Unit = {
    source.nearbyArea.foreach(node => source.infect(node))
  }
  
  def contaminate( source : String, number : Double ) : Unit = {
    network(source).infected += number
  }
  
  def block( area : Node ) : Unit = {
    area.contact = 0
  }
  
  def timeToSpread( time : Double, node : Node ) : Boolean = time % node.speed < tstep
  
  def sim( show : Boolean = false ) : Unit = {
    while (true) {
      step(show)
      
    }
  }
  
  def step( show : Boolean = false ) : Unit = {
    //noinspection DuplicatedCode
    Nodes.filter(node => timeToSpread(t, node)).foreach(node => spread(node))
    t += tstep
    if (show) {
      display()
    }
  }
  
  def display( ) : Unit = {
    Nodes.foreach(_.show())
  }
  
}
