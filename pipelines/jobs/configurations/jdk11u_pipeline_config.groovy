class Config11 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                test                : 'default',
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --with-cmake --with-mixedrefs'
                ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
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
                test                : 'default'
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
                ]
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                test                : 'default',
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --enable-jitserver --with-mixedrefs'
                ]

        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                test                : 'default',
                additionalFileNameTag: [
                        "openj9"    : "mixedrefs"
                ],
                configureArgs       : [
                        "openj9" : '--enable-dtrace=auto --with-mixedrefs',
                ]
                arch                 : 'x64',
                test                 : "default",
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-jitserver --enable-dtrace=auto'
        ],

        riscv64Linux      :  [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                arch                 : 'riscv64',
                crossCompile         : 'x64',
                buildArgs            : '--cross-compile',
                configureArgs        : '--disable-ddr --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root'
        ],
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
