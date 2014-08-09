gradle-wildfly-plugin
=====================

A Gradle/Groovy Hack to noodle around  (start | stop etc) with a local Wildfly (and probably) jboss instance

This plugin is described in a bit more detail [here](http://stupidfredtricks.blogspot.com/2014/08/a-simple-gradle-plugin-for-wildfly-and.html "gradle plugin for wildfly"). 


Usage:

1.  clone this repo
2.  build it with gradle
3.  use in your build file a bit like snippet below. 


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



Prorperties you can tweak:   

* wildfly_home = '/opt/wildfly'                 //where your wildfly lives
* start_script = 'standalone.sh'                //script to start it 
* cli_script = 'jboss-cli.sh'                   //cli script for stopping and deploys
* start_regex = '^.*started in.*- Started.*$'   //REGEX used to look for Wildfly's startup log message
* path_to_deployable = null                     //where your deploy is   
* deployment_name = null                        //name of deployable 

This is very much work in progress.   I have really only used it on a EAR style archive.  
I have NOT added all the possible configuration options (ports, work for WAR or JAR projects etc) that it probably should have.   
Feel free to hack away at it. 