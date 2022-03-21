package cliche

import com.typesafe.config.{ConfigFactory, Config => TypesafeConfig}
import net.ceedubs.ficus.Ficus._
import java.io.File

class Config(datadir: File) {
  val resourcesDir: File = new File(datadir, ".")
  val assetsDir: File = new File(datadir, "./assets")

  val config: TypesafeConfig =
    ConfigFactory parseFile new File(resourcesDir, "wallet.conf")

  val network: String = config.as[String]("config.network")
  val mnemonics: List[String] =
    config.as[String]("config.seed").split(" ").toList
}
