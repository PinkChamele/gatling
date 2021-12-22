package simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class GetJSONSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Get simple json")
      .exec(
        http("get_json_request")
          .get("/json")
      )

  setUp(scn.inject(
    rampUsersPerSec(5) to 10 during 10)
    .protocols(httpProtocol)
  )
}
