gradle-wildfly-plugin
=====================

A Gradle/Groovy Hack to noodle around  (start | stop etc) with a local Wildfly (and probably) jboss instance

This plugin is described in a bit more detail [here](http://stupidfredtricks.blogspot.com/2014/08/a-simple-gradle-plugin-for-wildfly-and.html "gradle plugin for wildfly"). 


Usage:

1.  clone this repo
2.  build it with gradle
3.  use in your build file like this:


    apply plugin: 'wildfly'

    buildscript {
        repositories {
            flatDir {
                dirs '../gradle-wildfly-plugin/build/libs'
            }
        }     
        dependencies {
            classpath name: 'gradle-wildfly-plugin'
        }
    }
    .
    .
    .
    wildfly
    {
       wildfly_home = '/opt/wildfly-8.1.0.Final'
       deployment_name = 'Schlepp'
    }