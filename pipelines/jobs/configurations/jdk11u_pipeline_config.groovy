class Config11 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                test                : 'default',
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                additionalNodeLabels: 'ci.project.openj9 && ci.role.build && hw.arch.x86 && sw.os.osx.10_14',
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --with-cmake --with-mixedrefs'
                ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                additionalFileNameTag: "mixedrefs",
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile          : 'pipelines/build/dockerFiles/cuda.dockerfile',
                dockerNode          : 'sw.tool.docker&&sw.config.uid1000',
                test                : 'default',
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --enable-dtrace=auto --with-mixedrefs'
                ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                configureArgs       : [
                        "openj9"      : '--with-mixedrefs'
                ],
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                test                : 'default',
                additionalNodeLabels : 'ci.project.openj9&&sw.os.windows&&ci.role.build.release'
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                configureArgs       : [
                        "openj9"      : '--with-mixedrefs'
                ],
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                cleanWorkspaceAfterBuild: true
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.ppc64&&sw.os.aix.7_1',
                test                : 'default'
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --with-mixedrefs'
                ],
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.s390x&&(sw.os.cent.7||sw.os.rhel.7)'
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                test                : 'default',
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.ppc64le&&(sw.os.cent.7||sw.os.rhel.7)',
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --enable-jitserver --with-mixedrefs'
                ]
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                test                : 'default',
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                configureArgs       : [
                        "openj9" : '--enable-dtrace=auto --with-mixedrefs',
                ]
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.linux'
        ],

        riscv64Linux      :  [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                dockerNode         : 'sw.tool.docker&&sw.config.uid1000',
                arch                 : 'riscv64',
                crossCompile         : 'x64',
                buildArgs            : '--cross-compile',
                configureArgs        : '--disable-ddr --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root --with-mixedrefs',
                additionalFileNameTag: "mixedrefs",
                test                : false
        ]
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
