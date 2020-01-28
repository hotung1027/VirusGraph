package object virusgraph {
  
  import graph.{ Node, Graph }
  
  def r0f : (Double, Double, Double) => Double = { ( a : Double, b : Double, c : Double ) => a * b * c }
  
  /** Node(  location : String, nearArea : List[Node], population : Double,infected : Double, speed : Double, contact : Double, mobility : Double,
   * r0f : (Double, Double, Double) => Double,
   * var prob : Double )
   *
   * */
  val HongKongDistricts : Array[(String, List[String], Double, Double, Double, Double, Double)] = Array(
    ("Central & Western", List("Wan Chai", "Southern", "Islands"), 242400, 0, 1, 1.3, 2),
    ("Wan Chai", List("Central & Western", "Eastern", "Southern", "Sham Shui Po"), 180200, 0, 1, 1.4, 2),
    ("Eastern", List("Southern", "Wan Chai"), 546300, 0, 1, 1.5, 2.2),
    ("Southern", List("Eastern", "Islands"), 266000, 0, 1, 1.1, 1.7),
    ("Sham Shui Po", List("Kwun Tong", "Sha Tin", "Kwai Tsing", "Wan Chai", "Wong Tai Sin"), 396800, 0, 1, 1.3, 1.5),
    ("Wong Tai Sin", List("Sham Shui Po", "Kwun Tong", "Sha Tin"), 419000, 0, 1, 1.4, 1.5),
    ("Kwun Tong", List("Sham Shui Po", "Sha Tin", "Sai Kung", "Eastern", "Wan Chai"), 677300, 0, 1, 1.9, 2),
    ("Kwai Tsing", List("Tsuen Wan", "Sha Tin", "Sham Shui Po", "Yuen Long", "Tuen Mun"), 507000, 0, 1, 1.3, 1.5),
    ("Tsuen Wan", List("Tuen Mun", "Yuen Long", "Tai Po", "Kwai Tsing", "Sha Tin"), 311100, 0, 1, 1.7, 1.8),
    ("Tuen Mun", List("Yuen Long", "Tsuen Wan"), 494500, 0, 1, 1.3, 1.5),
    ("Yuen Long", List("Tuen Mun", "Tai Po", "North", "Tsuen Wan"), 635600, 0, 1, 1.3, 1.5),
    ("North", List("Tai Po", "Yuen Long"), 314800, 0, 1, 1.3, 1.3),
    ("Tai Po", List("Tsuen Wan", "North", "Yuen Long", "Sha Tin", "Sai Kung"), 307700, 0, 1, 1.2, 1.2),
    ("Sha Tin", List("Tai Po", "Sai Kung", "Kwun Tong", "Sham Shui Po", "Kwai Tsing", "Tsuen Wan", "Yuen Long"), 681100, 0, 1, 1.4, 1.4),
    ("Sai Kung", List("Kwun Tong", "Tai Po", "Sha Tin"), 469200, 0, 1, 1.2, 1.4),
    ("Islands", List("Tuen Mun", "Tsuen Wan", "Central & Western"), 170900, 0, 1, 0.3, 0.5)
  )
  var HongKongGraph : Graph = new Graph(0.5, HongKongDistricts.map { case (location, nearArea, population, infected, speed, contact, mobility) => new Node(location = location, nearbyArea = List(), speed = speed, population = population, infected = infected, contact = contact, mobility = mobility, r0f = r0f, prob = 0.3) }.toList)
  val update : Unit = HongKongDistricts.foreach { case (location, nearArea, population, infected, speed, contact, mobility) => nearArea.foreach(node => HongKongGraph.network(location).connect(HongKongGraph.network(node))) }
  
}
