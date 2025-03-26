package moe.chestnut.awa.opentbs

import net.fabricmc.api.ModInitializer
import org.slf4j.{LoggerFactory, Logger}
import moe.chestnut.awa.opentbs.item.Items

object OpenTBS extends ModInitializer:
  private val logger: Logger = LoggerFactory.getLogger("opentbs")

  Items.initialize()

  override def onInitialize(): Unit =
    logger.info("Hello Fabric world!")
