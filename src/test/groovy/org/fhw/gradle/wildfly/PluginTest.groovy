package org.fhw.gradle.wildfly
import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class PluginTest {
    
    @Test
    public void addPluginTest()
    {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'wildfly'
        assertTrue(project.tasks.deploy instanceof DeployWildFlyTask)
        assertTrue(project.tasks.undeploy instanceof UndeployWildFlyTask)
        assertTrue(project.tasks.start instanceof StartWildFlyTask)
        assertTrue(project.tasks.stop instanceof StopWildFlyTask)
    }
	
}

