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
            ProcessBuilder builder = new ProcessBuilder(getStarterScript())
            builder.directory(new File(binDir))                    
            builder.redirectErrorStream(true)
            Process process = builder.start()            
            InputStream stdout = process.getInputStream()
            BufferedReader reader = new BufferedReader(new InputStreamReader(stdout)) 
            def reggie = getStartRegex()
            def line
            while ((line = reader.readLine()) != null) {
                if (line.matches(reggie)) {
                    println line
                    break
                }
            }            
        }
        else
        {
            println "seems like wildfly is already started."
        }
    }
}


