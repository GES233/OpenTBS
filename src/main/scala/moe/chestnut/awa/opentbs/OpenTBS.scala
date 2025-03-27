package moe.chestnut.awa.opentbs

import net.fabricmc.api.ModInitializer
import org.slf4j.{LoggerFactory, Logger}
import moe.chestnut.awa.opentbs.item.Items

object OpenTBS extends ModInitializer:
  val logger: Logger = LoggerFactory.getLogger("opentbs")

  Items.initialize()

  override def onInitialize(): Unit =
    logger.warn(
      "This script required extracts assets from the broken script v1.9.3 for 1.20.1 forge. " +
      "Ensure you have legally obtained the JAR file. " +
      "The author of this project is not responsible for misuse."
    )

    logger.info("Hello Fabric world!")
