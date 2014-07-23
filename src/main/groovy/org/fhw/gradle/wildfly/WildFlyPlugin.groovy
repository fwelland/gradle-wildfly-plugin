package org.fhw.gradle.wildfly

import org.gradle.api.Project
import org.gradle.api.Plugin

class WildFlyPlugin implements Plugin<Project> {
    
    
    @Override
    void apply(Project project) {        
        
//        project.configurations.create(CONFIGURATION_NAME)
//               .setVisible(true)
//               .setTransitive(true)
//               .setDescription('zeee Wildfy hack-plugin.')
        
        project.extensions.create("wildfly", WildFlyPluginExtension)        
        project.task('start', type: StartWildFlyTask)
    }
    
   
}
