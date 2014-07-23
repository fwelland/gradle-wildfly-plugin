package org.fhw.gradle.wildfly

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class StartWildFlyTask extends BaseWildFlyTask {
    	
    @TaskAction
    def start() {
        def binDir = getWildFlyBinDir()
        if( ! isUp() )
        {        
            def cliLog = new File(binDir, 'g-gf-wfstart.txt') 
            if (cliLog.exists())
            {
                cliLog.delete() 
            }
            ProcessBuilder builder = new ProcessBuilder(getStarterScript())
            builder.directory(new File(binDir))                    
            builder.redirectErrorStream(true)
            builder.redirectOutput(cliLog)
            Process process = builder.start()        
        }
    }
}
