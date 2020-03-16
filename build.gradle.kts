import org.jetbrains.intellij.tasks.RunIdeTask

tasks.withType<RunIdeTask> {
    findProperty("luginDev")?.let { args = listOf(projectDir.absolutePath) }
}

plugins {
    id("org.jetbrains.intellij") version "0.4.7"
    kotlin("jvm") version "1.3.70"
}

intellij {
    pluginName = "idear"
    updateSinceUntilBuild = false
    setPlugins("AceJump:3.5.4")
}

group = "org.openasr"
version = "1.3.4"

repositories {
    jcenter()
    maven("https://oss.sonatype.org/content/repositories/releases/")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    compile("net.sourceforge.javaflacencoder:java-flac-encoder:0.3.7")
    compile("edu.cmu.sphinx:sphinx4-core:5prealpha-SNAPSHOT")
    compile("com.mashape.unirest:unirest-java:1.4.9")
    compile("org.codehaus.jettison:jettison:1.4.0")
    compile("de.dfki.mary:voice-cmu-slt-hsmm:5.2")
    compile("com.amazonaws:aws-java-sdk-cognitoidentity:1.11.340")
    compile("com.amazonaws:aws-java-sdk-lex:1.11.340")
    compile("com.amazonaws:aws-java-sdk-polly:1.11.340")
    compile("com.googlecode.soundlibs:jlayer:1.0.1.4")
    compile("com.google.cloud:google-cloud-speech:0.32.0-alpha")
    testCompile("junit:junit:4.12")
}
