package org.fhw.gradle.wildfly

import spock.lang.Specification
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project

class BaseWildFlyTaskSpec extends Specification {

    def "Test Get Wildfly Bin Directory Default"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'wildfly'
            
        when:
            String  binDir = project.tasks.deploy.getWildFlyBinDir()
            
        then:  
            binDir == "/opt/wildfly/bin"
    }
    
    def "Test Get CLI Script Default"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'wildfly'
            
        when:
            String  cli = project.tasks.deploy.getCliScript()
            
        then:  
            cli == '/opt/wildfly/bin/jboss-cli.sh'
    }
    
    def "Test Get CLI Script name default"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'wildfly'
            
        when:
            String  cli = project.tasks.deploy.getCliScriptName()
            
        then:  
            cli == 'jboss-cli.sh'
    }    
    
    
    
    def "Test Get Wildfly Bin Directory with spcified base"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'wildfly'
            project.wildfly.wildfly_home = '/opt/yar'
            
        when:
            String  binDir = project.tasks.deploy.getWildFlyBinDir()
            
        then:  
            binDir == "/opt/yar/bin"        
    }
    
    def "Test ability to fetch the deployment name when wildfly plugin closure provides a name "()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'wildfly'
            project.wildfly.path_to_deployable = '/usr/overthere/frank-burns.ear'
            
        when:
            String  nme = project.tasks.deploy.getDeploymentName()
            
        then:  
            nme == "frank-burns.ear"        
    }    
       
}

