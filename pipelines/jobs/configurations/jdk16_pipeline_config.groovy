class Config16 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'ci.project.openj9 && ci.role.build && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                additionalFileNameTag: "mixedrefs",
                configureArgs       : '--enable-dtrace --with-mixedrefs'
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage: [
                        openj9      : 'adoptopenjdk/centos7_build_image'
                ],
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker&&sw.config.uid1000',
                test                : 'default',
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)'
                ],
                additionalFileNameTag: "mixedrefs",
                configureArgs       : [
                        "openj9"      : '--enable-dtrace --enable-jitserver --with-mixedrefs'
                ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9&&sw.os.windows&&ci.role.build.release',
                configureArgs       : [
                        "openj9"      : '--with-mixedrefs'
                ],
                additionalFileNameTag: "mixedrefs",
                test                : 'default'
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.ppc64&&sw.os.aix.7_1',
                test                : 'default'
        ],


        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.s390x&&(sw.os.cent.7||sw.os.rhel.7)',
                additionalFileNameTag: "mixedrefs",
                configureArgs       : '--enable-dtrace --with-mixedrefs'
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                additionalNodeLabels : 'ci.project.openj9&&ci.role.build.release&&hw.arch.s390x&&(sw.os.cent.7||sw.os.rhel.7)',
                test                : 'default',
                additionalFileNameTag: "mixedrefs",
                configureArgs       : [
                        "openj9"      : '--enable-dtrace --enable-jitserver --with-mixedrefs'
                ]

        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.linux',
                test                : false,
                additionalFileNameTag: "mixedrefs",
                configureArgs       : '--enable-dtrace --with-mixedrefs'
        ]
  ]

}

Config16 config = new Config16()
return config.buildConfigurations
