package edu.colorado.cs.epic

//Defining our own OSM Data models!
//	TODO: Can I do this with the geow models?

case class MetaChangeset(
		id: String,
	    created_at: String,
	    closed_at: String,   //These should be Option[], but it freaks out
	    open: Boolean,
	    num_changes: Integer,
	    user: String,
	    uid: String,
	    min_lat: Double,
	    max_lat: Double,
	    min_lon: Double,
	    max_lon: Double,
	    comments_count: Integer,
	    source: String,
	    created_by: String,
	    comment: String,
	    elements: List[Map[String,Object]]
	){
		//Now handle the processing of the elements
		val nodes = elements.filter(e => e("type") == "node"  && e("action") != "delete").map{ n => 
			Node(	n("id").asInstanceOf[String],
					n("timestamp").asInstanceOf[String],
					n("version").asInstanceOf[String].toInt,
					n("changeset").asInstanceOf[String],
					n("user").asInstanceOf[String],
					n("uid").asInstanceOf[String],
					n("tags").asInstanceOf[Map[String,String]],
					n("lat").asInstanceOf[String].toDouble,
					n("lon").asInstanceOf[String].toDouble
				)
		}

		val ways  = elements.filter(e => e("type") == "way" && e("action") != "delete" ).map{ w =>
			Way(	w("id").asInstanceOf[String],
					w("timestamp").asInstanceOf[String],
					w("version").asInstanceOf[String].toInt,
					w("changeset").asInstanceOf[String],
					w("user").asInstanceOf[String],
					w("uid").asInstanceOf[String],
					w("tags").asInstanceOf[Map[String,String]],
					w("nodes").asInstanceOf[List[Map[String,String]]]
				)
		}

		val deleted_items = elements.filter(_("action") == "delete")
}

abstract class Point(

)

abstract class OSMObject(
	id: String,
	timestamp: String,
	version: Integer,
	changeset: String,
	user: String,
	uid:  String,
	tags: Map[String,String])
	{
}

case class Node(
		id: String,
		timestamp: String,
		version: Integer,
		changeset: String,
		user: String,
		uid:  String,
		tags: Map[String,String],
		lat: Double,
		lon: Double
	)extends OSMObject(id, timestamp, version, changeset, user, uid, tags)
	{

		//Node functions here
}

case class WayNode(node_id: String, lat: Double, lon: Double){
}

case class Way(
		id: String,
		timestamp: String,
		version: Integer,
		changeset: String,
		user: String,
		uid:  String,
		tags: Map[String,String],
		refs: List[Map[String,String]]
	)extends OSMObject(id, timestamp, version, changeset, user, uid, tags)
	{
		val nodes = refs.map{o => 
			WayNode(o("ref"), o("lat").toDouble, o("lon").toDouble)
		}
}
