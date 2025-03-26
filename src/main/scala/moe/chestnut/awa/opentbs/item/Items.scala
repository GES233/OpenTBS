package moe.chestnut.awa.opentbs.item

import net.minecraft.item.Item
import net.minecraft.registry.{RegistryKey, RegistryKeys, Registry, Registries}
import net.minecraft.util.{Identifier, Rarity}
import net.fabricmc.fabric.api.item.v1.FabricItemSettings

object Items:
  def initialize(): Unit = { }

  private def register(path: String, item: Item): Item =
    val itemKey: RegistryKey[Item] = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("opentbs", path))

    Registry.register(Registries.ITEM, itemKey, item)

    item

  // opentbs:null
  // net.mcreator.interpritation.item.NItem
  val NULL: Item = register(
    "null",
    DisappearWhenUse(FabricItemSettings().maxCount(64).rarity(Rarity.COMMON))
  )

  // opentbs:gore
  // net.mcreator.interpritation.item.GoreItem
  // same as null
  val GORE: Item = register(
    "gore",
    DisappearWhenUse(FabricItemSettings().maxCount(64).rarity(Rarity.COMMON))
  )

  // TODO
  // opentbs:record_14(disc14new.ogg)
  // net.mcreator.interpritation.item.Record14Item
  val RECORD14: Item = register(
    "record_14",
    Item(FabricItemSettings().maxCount(1).rarity(Rarity.COMMON))
  )

  // TODO
  // opentbs:record_15(disc15.betray.ogg)
  // net.mcreator.interpritation.item.Record15Item
  val RECORD15: Item = register(
    "record_15",
    Item(FabricItemSettings().maxCount(1).rarity(Rarity.COMMON))
  )

  // TODO
  // opentbs:record_16(disc16.youcant.ogg)
  // net.mcreator.interpritation.item.Record16Item
  val RECORD16: Item = register(
    "record_16",
    Item(FabricItemSettings().maxCount(1).rarity(Rarity.COMMON))
  )
