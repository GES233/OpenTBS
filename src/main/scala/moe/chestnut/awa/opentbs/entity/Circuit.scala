package moe.chestnut.awa.opentbs.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.mob.MobEntity
import net.minecraft.world.World
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.util.GeckoLibUtil

// merge into mod after done
// required: assets related
class Circuit(
    `type`: EntityType[? <: Circuit],
    world: World
) extends MobEntity(`type`, world)
    with GeoEntity:
  private val geoCache: AnimatableInstanceCache =
    GeckoLibUtil.createInstanceCache(this)
  private var anianimationprocedure: String = "empty"
  private var prevAnim: String = "empty"

  // Add a new constructor when triggered event.

  def initialize: Unit = {}

  def getAnimatableInstanceCache(): AnimatableInstanceCache = this.geoCache

  def registerControllers(controllers: ControllerRegistrar): Unit = {}
