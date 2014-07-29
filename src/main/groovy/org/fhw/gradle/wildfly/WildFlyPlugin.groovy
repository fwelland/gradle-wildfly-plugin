package org.fhw.gradle.wildfly

import org.gradle.api.Project
import org.gradle.api.Plugin

class WildFlyPlugin implements Plugin<Project> {
        
    @Override
    void apply(Project project) {        
                
        project.extensions.create("wildfly", WildFlyPluginExtension)        
        project.task('start', type: StartWildFlyTask)
        project.task('stop', type: StopWildFlyTask)        
        project.task('deploy', type: StopWildFlyTask)                
    }       
}
