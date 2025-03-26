package moe.chestnut.awa.opentbs.item

import moe.chestnut.awa.opentbs.OpenTBS
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.{Hand, TypedActionResult}
import net.minecraft.world.World

/**
 * Item will disappear when use it(not working in creative mode).
 * 
 * like: `net.mcreator.interpritation.procedures.NRightclickedProcedure` in TBS
*/
class DisappearWhenUse(settings: Item.Settings) extends Item(settings):
  override def use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult[ItemStack] =
    val stack: ItemStack = user.getStackInHand(hand)
    if !world.isClient && !user.getAbilities.creativeMode then
      stack.decrement(1)

    TypedActionResult.success(stack, world.isClient)
