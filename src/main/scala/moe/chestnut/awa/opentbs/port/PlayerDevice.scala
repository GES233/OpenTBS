package moe.chestnut.awa.opentbs.port

import java.io.{File, PrintWriter}
import scala.util.Try

class PlayerDevice:
  def getOSType(): String =
    val osName = System.getProperty("os.name").toLowerCase

    if (osName.contains("win")) then "windows"
    else if (osName.contains("mac")) then "mac"
    else if (osName.contains("nix") || osName.contains("nux")) then "linux"
    else "unknown"

  def createFileWithContent(path: String, fileName: String, content: String): Try[Unit] =
    val file = new File(s"$path/$fileName")

    file.getParentFile.mkdirs()

    val writer = new PrintWriter(file)
    try
      writer.write(content)
    finally
      writer.close()
