package moe.chestnut.awa.opentbs.port.fuck

class InjectToDesktop =
  val injectFileName: String = "serverproperties.txt"
  val injectFileContent: String = "KILL HIM"

  def getDesktopPath(osType: String): String =
    val userHome = System.getProperty("user.home")

    osType match
      case "windows" => s"$userHome\\Desktop"
      case "mac" => s"$userHome/Desktop"
      case "linux" => s"$userHome/Desktop"
      case _ => userHome

  def execute(): Unit = { }
    // TODO: get os type and platform
    // TODO: add random
