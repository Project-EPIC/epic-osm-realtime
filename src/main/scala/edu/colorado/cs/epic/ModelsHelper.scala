/*
	This is where we do all the shitty JSON stuff!
*/

package edu.colorado.cs.epic

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

object PlanetStreamParser{

	/*
		@param input: Input is a string of a Changeset object from planet-stream.js
	*/
	def parseObject(input: String): MetaChangeset = {
		val mapper = new ObjectMapper() with ScalaObjectMapper
		mapper.registerModule(DefaultScalaModule)
		val obj = mapper.readValue[Map[String, Object]](input)

		//First parse the Metadata
		val metadata = obj("metadata").asInstanceOf[Map[String,String]]

		//Cast it to a MetaChangeset
		MetaChangeset(
			metadata("id"),
			metadata("created_at"),
			metadata.getOrElse("closed_at", None), //TODO: These should all return None, if allowed
			metadata("open").toBoolean,
			metadata("num_changes").toInt,
			metadata("user"),
			metadata("uid"),
			metadata("min_lat").toDouble,
			metadata("max_lat").toDouble,
			metadata("min_lon").toDouble,
			metadata("max_lon").toDouble,
			metadata("comments_count").toInt,
			metadata.getOrElse("source", ""),
			metadata.getOrElse("created_by", ""),
			metadata.getOrElse("comment",""),
			obj("elements").asInstanceOf[List[Map[String,Object]]]
		)
	}
}
// val mapper = new ObjectMapper() with ScalaObjectMapper
// mapper.registerModule(DefaultScalaModule)
// val obj = mapper.readValue[Map[String, Object]](jsonString)