class Config11 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                test                : 'default',
                additionalNodeLabels: 'ci.project.openj9 && ci.role.build && hw.arch.x86 && sw.os.osx.10_14',
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --with-cmake'
                ]
        ],

        x64MacXL    : [
                os                   : 'mac',
                arch                 : 'x64',
                test                 : 'default',
                additionalNodeLabels: 'ci.project.openj9 && ci.role.build && hw.arch.x86 && sw.os.osx.10_14',
                additionalFileNameTag: "macosXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto --with-cmake'
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker&&sw.config.uid1000',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --enable-dtrace=auto'
                ]
        ],

        x64LinuxXL    : [
                os                   : 'linux',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker&&sw.config.uid1000',
                arch                 : 'x64',
                test                 : "default",
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-jitserver --enable-dtrace=auto'
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                test                : 'default',
                additionalNodeLabels : 'ci.project.openj9&&sw.os.windows&&ci.role.build.release'
        ],

        x64WindowsXL    : [
                os                   : 'windows',
                arch                 : 'x64',
                test                 : 'default',
                additionalNodeLabels : 'ci.project.openj9&&sw.os.windows&&ci.role.build.release',
                additionalFileNameTag: "windowsXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x32Windows: [
                os                  : 'windows',
                arch                : 'x86-32',
                test                : 'default',
                additionalNodeLabels : 'ci.project.openj9&&sw.os.windows&&ci.role.build.release'
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.ppc64&&sw.os.aix.7_1',
                test                : 'default'
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.s390x&&(sw.os.cent.7||sw.os.rhel.7)',
                configureArgs       : '--enable-dtrace=auto'
        ],

        s390xLinuxXL    : [
                os                   : 'linux',
                arch                 : 's390x',
                test                 : 'default',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.s390x&&(sw.os.cent.7||sw.os.rhel.7)',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto'
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                test                : 'default',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.ppc64le&&(sw.os.cent.7||sw.os.rhel.7)',
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --enable-jitserver'
                ]

        ],

        ppc64leLinuxXL    : [
                os                   : 'linux',
                arch                 : 'ppc64le',
                test                 : 'default',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.ppc64le&&(sw.os.cent.7||sw.os.rhel.7)',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto --enable-jitserver'
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                test                : false,
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.linux',
                configureArgs       : '--enable-dtrace=auto'
        ],

        aarch64LinuxXL    : [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                arch                 : 'aarch64',
                test                 : false,
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.linux',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto'
        ],

        riscv64Linux      :  [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                dockerNode         : 'sw.tool.docker&&sw.config.uid1000',
                arch                 : 'riscv64',
                crossCompile         : 'x64',
                buildArgs            : '--cross-compile',
                configureArgs        : '--disable-ddr --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root'
        ]
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
