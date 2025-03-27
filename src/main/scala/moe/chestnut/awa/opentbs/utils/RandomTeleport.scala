package moe.chestnut.awa.opentbs.utils

import net.minecraft.entity.Entity
import net.minecraft.world.level.{LevelInfo, LevelProperties}
import net.minecraft.world.level.storage.LevelStorage
import moe.chestnut.awa.opentbs.OpenTBS
import java.util.Random
import net.minecraft.util.math.{Vec3d, BlockPos}
import net.minecraft.world.World
import net.minecraft.block.Blocks

// net.mcreator.interpritation.RandomSafeTeleport
class RandomTeleport():
  def teleport(entity: Entity): Unit =
    val world: World = entity.getWorld()
    val seed = Random(_)
    val originPos: BlockPos = entity.getBlockPos()

    // Try 10 times
    val maybeSafePosList = Range(1, 10)
      .map(_ => isSafe(world, genPos(originPos, world, seed(21))))
      .filter(
        _ match
          case (true, _) => true
          case _         => false
      )
      .map(
        _ match
          case (_, safePos) => safePos
      )

    // teleport entity
    if maybeSafePosList.length >= 1 then
      val pos = maybeSafePosList.apply(1)
      OpenTBS.logger.info(s"Teleport play to ${pos}")

      entity.teleport(pos.getX().+(0.5), pos.getY().+(0.0), pos.getZ().+(0.5))

  def isSafe(world: World, pos: BlockPos): Tuple2[Boolean, BlockPos] =
    val blockCanHoldEntity =
      world.getBlockState(pos.down()).isSolidBlock(world, pos)

    val enoughSapceToContainerEntity =
      world.getBlockState(pos).isAir() && world.getBlockState(pos.up()).isAir()

    val noFluidInSpace =
      world.getBlockState(pos.down()).getBlock() != Blocks.LAVA && world
        .getBlockState(pos.down())
        .getBlock() != Blocks.SOUL_SAND

    Tuple2(
      blockCanHoldEntity && enoughSapceToContainerEntity && noFluidInSpace,
      pos
    )

  private def genPos(
      originPos: BlockPos,
      world: World,
      seed: Random
  ): BlockPos =
    BlockPos(
      originPos.getX() + seed.nextInt() - 10,
      world.getTopY(),
      originPos.getZ() + seed.nextInt() - 10
    )
