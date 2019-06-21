package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'SampleMavenbuild'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("SampleMavenbuild")) {
    check(publishArtifacts == PublishMode.NORMALLY_FINISHED) {
        "Unexpected option value: publishArtifacts = $publishArtifacts"
    }
    publishArtifacts = PublishMode.SUCCESSFUL

    expectSteps {
        maven {
            name = "maven build"
            goals = "clean"
            pomLocation = "simple/pom.xml"
            workingDir = "simple"
            mavenVersion = custom {
                path = "/opt/apache-maven-3.6.1/bin"
            }
            jdkHome = "/usr/lib/jvm/java-11-openjdk-amd64"
        }
    }
    steps {
        update<MavenBuildStep>(0) {
            mavenVersion = defaultProvidedVersion()
        }
    }
}
