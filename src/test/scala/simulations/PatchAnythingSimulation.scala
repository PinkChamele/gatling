package simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class PatchAnythingSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Patch anything")
      .exec(
        http("patch_anything_request")
          .patch("/anything")
      )

  setUp(scn.inject(
    rampUsersPerSec(5) to 10 during 10)
    .protocols(httpProtocol)
  )
}
