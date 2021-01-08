class Config8 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac        : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'ci.project.openj9 && ci.role.build && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default'
        ],

        x64MacXL      : [
                os                   : 'mac',
                arch                 : 'x64',
                test                 : 'default',
                additionalFileNameTag: "macosXL",
                additionalNodeLabels : 'ci.project.openj9 && ci.role.build && hw.arch.x86 && sw.os.osx.10_14',
                configureArgs        : '--with-noncompressedrefs'
        ],

        x64Linux      : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker&&sw.config.uid1000',
                test                 : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver'
                ]
        ],

        x64LinuxXL       : [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker&&sw.config.uid1000',
                arch                 : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-jitserver',
                test                 : 'default'
        ],

        x64Windows    : [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9&&sw.os.windows&&ci.role.build.release',
                test                 : 'default'
        ],

        x64WindowsXL    : [
                os                   : 'windows',
                arch                 : 'x64',
                additionalNodeLabels : 'ci.project.openj9&&sw.os.windows&&ci.role.build.release',
                test                 : 'default',
                additionalFileNameTag: "windowsXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x32Windows    : [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels : 'ci.project.openj9&&sw.os.windows&&ci.role.build.release',
                test                 : 'default'
        ],

        ppc64Aix      : [
                os  : 'aix',
                arch: 'ppc64',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.ppc64&&sw.os.aix.7_1',
                test                 : 'default'
        ],

        s390xLinux    : [
                os  : 'linux',
                arch: 's390x',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.s390x&&(sw.os.cent.7||sw.os.rhel.7)',
                test                 : 'default'
        ],

        s390xLinuxXL       : [
                os                   : 'linux',
                arch                 : 's390x',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.s390x&&(sw.os.cent.7||sw.os.rhel.7)',
                additionalFileNameTag: "linuxXL",
                test                 : 'default',
                configureArgs        : '--with-noncompressedrefs'
        ],

        ppc64leLinux  : [
                os  : 'linux',
                arch: 'ppc64le',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.ppc64le&&(sw.os.cent.7||sw.os.rhel.7)',
                test                 : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver'
                ]
        ],

        ppc64leLinuxXL       : [
                os                   : 'linux',
                arch                 : 'ppc64le',
                additionalFileNameTag: "linuxXL",
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.ppc64le&&(sw.os.cent.7||sw.os.rhel.7)',
                test                 : 'default',
                configureArgs        : '--with-noncompressedrefs --enable-jitserver'
        ],

        aarch64Linux  : [
                os                  : 'linux',
                arch                : 'aarch64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                test                 : 'default'
        ]
  ]

}

Config8 config = new Config8()
return config.buildConfigurations
