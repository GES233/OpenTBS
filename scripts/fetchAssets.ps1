# Copy TBS's assets into this repo.

# TODO: implement get tbs's path and verify hash
function Get-TheBrokenScript {
    param (
        [string]$LocalPath
    )
    # check file exist
    # 检查文件是否存在
    if (-not (Test-Path -Path $LocalPath -PathType Leaf)) {
        Write-Warning "File: $LocalPath not exist"
        return $false
    }

    # Only thebrokenscript-1.9.3-forge-1.20.1.jar
    $fileHash = '79D2885AB7F74698313B21A5161C74ABC55A02F3E1069080FB3A4DEF31C3A460'

    try {
        $hash = Get-FileHash -Path $LocalPath -Algorithm "SHA256" -ErrorAction Stop
        $hashMatch = ($hash.Hash -eq $fileHash)

        if ($hashMatch) { return $true }
        else { return $false }
    }
    catch {
        Write-Error "Hash Computation Error"
        return $false
    }
}

# TODO: unzip to temp
function Build-UnzipJarDir {
    param (
        $ValidJarPath
    )

    # Create a folder under temp

    # unzip jar file to that place

    # return new path(root)
}

<#
assetsMapper = [
  ("logo.png", "assets/open-tbs/logo.png"),
  ("assets/thebrokenscript/sounds", "assets/open-tbs/sounds")
]
#>

# rootPath = "src/main/resources"

# TODO: cleanup file in assets
# delete all and revert under specific folder
# or maintain mapper
function Clear-AssetsInSrcFolder {}

# TODO: copy item recursively
# use a mapper
# logo.png => src/main/resources/assets/open-tbs/icon.png
# assets/minecraft => ???
# assets/thebrokenscript/sounds => src/main/resources/assets/open-tbs/sounds
# geckolib related -> do copy
# datagen content(e.g. lang): ignore

function Switch-LogoInMod {
    $filePath = "src/main/resources/fabric.mod.json"

    Get-Content $filePath -Raw
    | ConvertFrom-Json
    | Where-Object {$_.Name -eq "icon"}
}
