package org.fhw.gradle.wildfly

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class DeployWildFlyTask extends BaseWildFlyTask {
    	        
    @TaskAction
    def deploy() {
        def binDir = getWildFlyBinDir()
        if( isUp() )
        {       
//            def dpl = "deploy --force [PATH_TO_WAR]"
//            executeSingleCLICommand(dpl)
println getFiles()
        }
        else
        {
            println "start wildfly first"
        }
    }
}


