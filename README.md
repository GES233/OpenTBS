# OpenTBS

Fabric and scala implementation of the broken script.

## How to use

Due to The Broken Script's copyright, you should do some stuff when you download this repo.

```powershell
.\scripts\fetchAssets.ps1 -FilePath 'path/to/tbs.jar'
```

If migrate is done, may request the certification of wendigodrip.

## Inspection Result

_version: 1.9_

* `A.class`
  * Send `Err.<o>` message to player.
* `ChunkManipulationEngine.class`
  * `clearChunk`
* `CustomPlayerLayer.class`
  * replace player's skin?(renderColoredCutoutModel)
* `EntityAIMoveToTarget.class`
  * Set mod's AI(?)
* `ErrorPopup.class` ?
* `ExitDissable.class`
  * disable exit
* `Nomodsnoconfigs.class`
  * disable mod
* `Nooptions.class`
  * disable option
* `Norealms.class`
  * Disable realms
* `RandomSafeTeleport.class`
  * teleport entity to somewhere
  * try 10 times, if `isSafeLocation` => teleport player
    * can container player `world.getBlockState(pos.below()).isSolid() && world.getBlockState(pos).isAir() && world.getBlockState(pos.above()).isAir()`
    * reject fluid `world.getBlockState(pos.below()).getBlock() != Blocks.WATER && world.getBlockState(pos.below()).getBlock() != Blocks.LAVA;`
* `ThebrokenscriptMod.class`
  * Basic info
    * id: `thebrokenscript`
    * `PROTOCOL_VERSION`
  * Create a net channel to communicate
  * Add a scheduler to implement delay work and synchronize state between serve side and client side
  * registry assets
    * Sounds
    * Blocks
    * BlockEntities
    * Items
    * Entities
    * MobEffects
    * ParticleTypes
    * Menus

### command

* `DevmodeCommand.class`
  * `/TBS_devmode` => Enter 2018
  * `DevCheckProcedure.class`
  * `DevModeCommandExecuteProcedure.class`
  * `DevPassMenu.class`
* `DevModeCommandExecuteProcedure.class` ?
* ``

### world.dimension

* `ClanVoidDimension.class`
* `DayADimension.class`
* `DayBDimension.class`
* `NullTortureDimension.class`

### block

TBD

### 

