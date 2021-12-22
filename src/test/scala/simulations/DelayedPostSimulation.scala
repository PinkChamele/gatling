package simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class DelayedPostSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Create Post with Response delay")
      .exec(
        http("create_post_request")
          .post("/delay/2")
          .body(StringBody(
            """{title: 'Post title',
              |id: '433458bc-d151-4fdf-9dfd-0954497bb49a',
              |someData: 3}""".stripMargin))
      )

  setUp(scn.inject(
    rampUsersPerSec(5) to 10 during 10)
    .protocols(httpProtocol)
  ).assertions(
    global.responseTime.max.lt(2500),
  )
}
