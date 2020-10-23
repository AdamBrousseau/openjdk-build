class Config8 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac        : [
                os                  : 'mac',
                arch                : 'x64',
                test                 : 'default'
        ],

        x64MacXL      : [
                os                   : 'mac',
                arch                 : 'x64',
                test                 : 'default',
                additionalFileNameTag: "macosXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x64Linux      : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                test                 : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver'
                ]
        ],

        x64Windows    : [
                os                  : 'windows',
                arch                : 'x64',
                test                 : 'default'
        ],

        x64WindowsXL    : [
                os                   : 'windows',
                arch                 : 'x64',
                test                 : 'default',
                additionalFileNameTag: "windowsXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x32Windows    : [
                os                  : 'windows',
                arch                : 'x86-32',
                test                 : 'default'
        ],

        ppc64Aix      : [
                os  : 'aix',
                arch: 'ppc64',
                test                 : 'default'
        ],

        s390xLinux    : [
                os  : 'linux',
                arch: 's390x',
                test                 : 'default'
        ],

        ppc64leLinux  : [
                os  : 'linux',
                arch: 'ppc64le',
                test                 : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver'
                ]
        ],

        aarch64Linux  : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                test                 : 'default'
        ],

        x64LinuxXL       : [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                arch                 : 'x64',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-jitserver',
                test                 : 'default'
        ],
        s390xLinuxXL       : [
                os                   : 'linux',
                arch                 : 's390x',
                additionalFileNameTag: "linuxXL",
                test                 : 'default',
                configureArgs        : '--with-noncompressedrefs'
        ],
        ppc64leLinuxXL       : [
                os                   : 'linux',
                arch                 : 'ppc64le',
                additionalFileNameTag: "linuxXL",
                test                 : 'default',
                configureArgs        : '--with-noncompressedrefs --enable-jitserver'
        ],
  ]

}

Config8 config = new Config8()
return config.buildConfigurations