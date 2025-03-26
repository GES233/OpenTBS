# Copy TBS's assets into this repo.

# TODO: implement get tbs's path and verify hash
function Get-TheBrokenScript {
    param (
        [string]$LocalPath
    )
    # check file exist
    # 检查文件是否存在
    if (-not (Test-Path -Path $FilePath -PathType Leaf)) {
        Write-Warning "File: $FilePath not exist"
        return $false
    }

    # Only thebrokenscript-1.9.3-forge-1.20.1.jar
    $fileHash = ' 79D2885AB7F74698313B21A5161C74ABC55A02F3E1069080FB3A4DEF31C3A460'

    try {
        $hash = Get-FileHash -Path $FilePath -Algorithm "SHA256" -ErrorAction Stop
        $hashMatch = ($hash.Hash -eq $fileHash)

        return if ($hashMatch) $true else $false
    }
    catch {
        Write-Error "Hash Computation Error"
        return $false
    }
}

# TODO: unzip to temp
function Build-UnzipJarFile {
    param (
        $ValidJarPath
    )
}

assetsMapper = [
  ("logo.png", "src/main/resources/assets/open-tbs/icon.png"),
  ("assets/thebrokenscript/sounds", "src/main/resources/assets/open-tbs/sounds")
]

# TODO: cleanup file in assets
# delete all and revert under specific folder
# or maintain mapper

# TODO: copy item recursively
# use a mapper
# logo.png => src/main/resources/assets/open-tbs/icon.png
# assets/minecraft => ???
# assets/thebrokenscript/sounds => src/main/resources/assets/open-tbs/sounds
# datagen content(e.g. lang): ignore
