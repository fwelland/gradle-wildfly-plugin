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
    
    
    def getArchiveToDeploy()
    {
        def String arcPath = project.wildfly.path_to_deployable
        if(null == arcPath)
        {
            arcPath = project.ear.archivePath   
        }
        return arcPath
    }
    
    
    def getDeploymentName()
    {
        def String nm = project.wildfly.deployment_name
        if(null == nm)
        {             
            nm = project.name 
//            if (project.plugins.hasPlugin('war'))
//            {
//                nm = project.war.name
//            }
//            else if (project.plugins.hasPlugin('ear'))
//            {
//                nm = project.ear.name
//            }
        }
        return nm
    }    
    
    
//              return project.tasks.getByName(WarPlugin.WAR_TASK_NAME).archivePath
//        }
//        else if(project.plugins.hasPlugin(EarPlugin.EAR_TASK_NAME)) {
//            return project.tasks.getByName(EarPlugin.EAR_TASK_NAME).archivePath
//        }
    
    def getStartRegex()
    {
        return project.wildfly.start_regex
    }    
        
    def isUp()
    {        
        return( executeCLICommand(true, 'quit') )                 
    }
        
    
    def executeCLICommand(Boolean includeCMDOption, String ... commands)
    {
        def cmds = [getCliScript(), "--connect"]
        
        if(includeCMDOption)
        {            
            def cmd =  '--command="'
            for(String s : commands)
            {
                cmd += s
            }                
            cmd += '"'                
            cmds.add(cmd)
        }
        else
        {
            cmds.add('"')
            for(String s : commands)
                cmds.add(s)
            cmds.add('"')
        }
        ProcessBuilder builder = new ProcessBuilder( cmds )                                               
        builder.directory(new File(getWildFlyBinDir()))                
        builder.redirectErrorStream(true)
        Process process = builder.start()                
        InputStream stdout = process.getInputStream()
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout)) 
        def line
        while ((line = reader.readLine()) != null) 
        {   }       
        return( process.waitFor() == 0)                 
    }        
}
