package org.fhw.gradle.wildfly

import spock.lang.Specification
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project

class BaseASTaskSpec extends Specification {

    def "Test Get To See if CLI script is On Execution Path -- dummy yes case"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'wildfly'
            project.wildfly.cli_script=  'ls'
            
        when:
            def rc = project.tasks.deployExploded.isCLIScriptOnPath()
            
        then:  
            rc
    }
    
    
    def "Test Get To See if CLI script is On Execution Path -- dummy no case"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'wildfly'
            project.wildfly.cli_script=  'xxlsrrrpinkturtle'
            
        when:
            def rc = project.tasks.deployExploded.isCLIScriptOnPath()
            
        then:  
            !rc
    }    
}

