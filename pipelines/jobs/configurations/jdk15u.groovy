targetConfigurations = [
        "x64Mac"      : [
                "openj9"
        ],
        "x64MacXL"    : [
                "openj9"
        ],
        "x64Linux"    : [
                "openj9"
        ],
        "x64LinuxXL"  : [
                "openj9"
        ],
        "x64Windows"  : [
                "openj9"
        ],
        "x64WindowsXL": [
                "openj9"
        ],
        "ppc64Aix"    : [
                "openj9"
        ],
        "ppc64leLinux": [
                "openj9"
        ],
        "ppc64leLinuxXL": [
                "openj9"
        ],
        "s390xLinux"  : [
                "openj9"
        ],
        "s390xLinuxXL": [
                "openj9"
        ],
        "aarch64Linux": [
                "openj9"
        ],
        "aarch64LinuxXL": [
                "openj9"
        ]
]

// 23:30 Tue, Thur
triggerSchedule_nightly="TZ=UTC\n30 23 * * 2,4"
// 23:30 Sat
triggerSchedule_weekly="TZ=UTC\n30 23 * * 6"

// scmReferences to use for weekly release build
weekly_release_scmReferences=[
        "hotspot"        : "jdk-15.0.1+9_adopt",
        "openj9"         : "v0.24.0-release",
        "corretto"       : "",
        "dragonwell"     : ""
]

return this
