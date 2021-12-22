package simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class StatusSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Post with some status expected")
      .exec(
        http("post_status_request")
          .post("/status/201")
          .check(status.is(201))
      )

  setUp(scn.inject(
    rampUsersPerSec(5) to 10 during 10)
    .protocols(httpProtocol)
  )
}
