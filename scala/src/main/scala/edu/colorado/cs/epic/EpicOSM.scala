//
// Jennings Anderson & Project EPIC 2015
//
package edu.colorado.cs.epic

//http://www.geow.org/
import io.plasmap.parser.OsmParser

object EpicOSM {

	def read_pbf(file: String) = {

		println("Attempting to Read" + file)

		val parser = OsmParser(file)

		//println(x.isNode)

		// println( parser.osmObjects.getClass )

		parser.getClass.getMethods.map(m => 
			println(m.getName)
		)

		val x = parser.next

		// first_elem.getClass.getMethods.map(m => 
		// 	println(m.getName)
		// )
		
		//val byteArray = Files.readAllBytes(Paths.get(input))
		//val in = BlockInputStream( byteArray ).process()
		//println(in)
	}
}
