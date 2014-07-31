package org.fhw.gradle.wildfly

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class StopWildFlyTask extends BaseWildFlyTask {
    	
    @TaskAction
    def stop() {
        def binDir = getWildFlyBinDir()
        if( isUp() )
        {        
            executeCLICommand(true, 'shutdown')
        }
    }
}
