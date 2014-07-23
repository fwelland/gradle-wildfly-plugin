package org.fhw.gradle.wildfly

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class StartWildFlyTask extends BaseWildFlyTask {
	
    @TaskAction
    def start() {
        println project.wildfly.message
        def binDir = getWildFlyBinDir()
        println binDir
        
        
//        project.exec {
//                workingDir = binDir
//                commandLine  'nohup', 'standalone.sh', '&'
//                ignoreExitValue = false
//                //executable 'nohup'
//            }
//        ant.java()
//        {
//             
//       }
//       ant.exec( executable: 'sh')
//       {
//           
//       }
//       <target name="help">
//        <exec executable="cmd">
//        <arg value="/c"/>
//        <arg value="ant.bat"/>
//        <arg value="-p"/>
//        </exec>
        
        ProcessBuilder builder = new ProcessBuilder('standalone.sh')
        builder.redirectErrorStream(true)
        builder.directory(new File(binDir))        
        builder.redirectOutput(new File(binDir, 'g-gf-wfstart.txt'))
        Process process = builder.start()
        
        
        
        
        println "now what!!!!"    
    }
}
