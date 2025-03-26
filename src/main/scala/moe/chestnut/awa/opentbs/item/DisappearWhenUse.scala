package moe.chestnut.awa.opentbs.item

import moe.chestnut.awa.opentbs.OpenTBS
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.{Hand, TypedActionResult}
import net.minecraft.world.World

// net.mcreator.interpritation.procedures.NRightclickedProcedure
class DisappearWhenUse(settings: Item.Settings) extends Item(settings):
  override def use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult[ItemStack] =
    if world.isClient then
      TypedActionResult.pass(user.getStackInHand(hand))
    else
      // item - 1
      // better use var: nope
      var stack: ItemStack = user.getStackInHand(hand)
      stack.decrement(1)
      OpenTBS.logger.info(s"after: ${stack.getCount}")

      TypedActionResult.success(stack)
