package org.fhw.gradle.wildfly

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class DeployWildFlyTask extends BaseWildFlyTask {
    	        
    @TaskAction
    def deploy() {

        println 'deploy invoked'
        def binDir = getWildFlyBinDir()
        if( isUp() )
        { 
            println 'deploying!!'
            println "archive path " + project.ear.archivePath
            def dpl = "deploy " + getArchiveToDeploy()
println dpl
            executeSingleCLICommand(dpl)
            println "after execute..."
        }
        else
        {
            println "start wildfly first"
        }
    }
}


