package org.fhw.gradle.wildfly

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class BaseWildFlyTask extends DefaultTask {
    

    def getWildFlyBinDir()
    {
        return project.wildfly.wildfly_home + "/bin"
    }
    
    def getStarterScript()
    {
        return getWildFlyBinDir() + '/' + project.wildfly.start_script
    }

    def getCliScript()
    {
        return getWildFlyBinDir() + '/' + project.wildfly.cli_script
    }
    
    
    def getStartRegex()
    {
        return project.wildfly.start_regex
    }    
        
    def isUp()
    {        
        ProcessBuilder builder = new ProcessBuilder(getCliScript(), '--connect', 'command="quit"' )
        builder.directory(new File(getWildFlyBinDir()))                
        builder.redirectErrorStream(true)
        Process process = builder.start()                
        InputStream stdout = process.getInputStream()
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout)) 
        def line
        while ((line = reader.readLine()) != null) 
        {        }       
        return( process.waitFor() == 0)                 
    }
    
    
    def executeSingleCLICommand()
    {
        
    }
}
