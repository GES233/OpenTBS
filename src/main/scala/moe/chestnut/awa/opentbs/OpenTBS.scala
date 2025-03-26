package moe.chestnut.awa.opentbs

import net.fabricmc.api.ModInitializer
import org.slf4j.{LoggerFactory, Logger}

object OpenTBS extends ModInitializer:
  private val logger: Logger = LoggerFactory.getLogger(getClass)

  override def onInitialize(): Unit =
    logger.info("Hello Fabric world!")
