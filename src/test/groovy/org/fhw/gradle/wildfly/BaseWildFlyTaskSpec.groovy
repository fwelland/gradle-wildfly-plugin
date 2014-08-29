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
    
    def "Test Get Archive To Deploy"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'wildfly'
            project.apply plugin: 'ear'
        when:
            String  binDir = project.tasks.deploy.
        then:  
            binDir == "/opt/wildfly"        
    }
}

