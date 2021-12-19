package ua.com.zinchenko

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.ico"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")

	val headers_0 = Map("Proxy-Connection" -> "keep-alive")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0))
		.pause(7)
		.exec(http("request_1")
			.get("/computers?f=amstrad")
			.headers(headers_0))
		.pause(5)
		.exec(http("request_2")
			.get("/computers/412")
			.headers(headers_0))
		.pause(3)
		.exec(http("request_3")
			.get("/computers")
			.headers(headers_0))
		.pause(5)
		.exec(http("request_4")
			.get("/computers?p=1&n=10&s=name&d=asc")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_5")
			.get("/computers?p=2&n=10&s=name&d=asc")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_6")
			.get("/computers?p=3&n=10&s=name&d=asc")
			.headers(headers_0))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}