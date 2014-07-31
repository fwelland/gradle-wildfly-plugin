package org.fhw.gradle.wildfly

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class UndeployWildFlyTask extends BaseWildFlyTask {
    	        
    @TaskAction
    def undeploy() {

        def binDir = getWildFlyBinDir()
        if( isUp() )
        { 
            executeCLICommand(false, "undeploy", getDeploymentName())
        }
        else
        {
            println "start wildfly first"
        }
    }
}


