//     Project: angulate2-examples
//      Module: 01_tour_of_heroes
// Description: Data class for heroes

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2.std._
import angulate2.ext.data._

import scala.scalajs.js

@Data
@debug
case class Hero(id: Int, name: String) extends js.Any
