//     Project: angulate2-examples
//      Module: 01_tour_of_heroes
// Description: Heroes component for the Tour of Heroes app

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2.ext.debug
import angulate2.std._
import angulate2.router.Router

import scala.scalajs.js

@Component(
  selector = "my-heroes",
  templateUrl = "/src/main/resources/heroes.component.html",
  styleUrls = @@@("src/main/resources/heroes.component.css")
)
class HeroesComponent(router: Router,
                      heroService: HeroService) extends OnInit {
  var heroes: js.Array[Hero] = _
  var selectedHero: js.UndefOr[Hero] = _

  def getHeroes(): Unit = heroService.getHeroes.map( this.heroes = _ )

  override def ngOnInit(): Unit = getHeroes()

  def onSelect(hero: Hero): Unit = selectedHero = hero

  def gotoDetail(): Unit = router.navigateTo("/detail",this.selectedHero.get.id)

  def add(name: String): Unit = name.trim match {
    case "" =>
    case newHero => heroService.create(newHero).map { hero =>
      this.heroes.push(hero)
      this.selectedHero = hero
    }
  }

  def delete(hero: Hero): Unit = heroService
    .delete(hero.id)
    .map{ _ =>
      this.heroes = this.heroes.filter(_ != hero)
      if(selectedHero == hero)
        selectedHero = js.undefined
    }

}

