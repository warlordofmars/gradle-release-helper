package com.github.warlordofmars.gradle.release

import org.gradle.api.Plugin
import org.gradle.api.Project

class ReleaseHelperPlugin implements Plugin<Project> {

    void apply(Project project) {

        project.plugins.apply('pl.allegro.tech.build.axion-release')
        project.plugins.apply('com.github.breadmoirai.github-release')

        
        project.version = project.scmVersion.version
        
        if(project.hasProperty('github.token')) {

            project.scmVersion.repository.customUsername = project.getProperty('github.token')

            project.githubRelease {
                token project.getProperty('github.token')
                tagName "release-${project.version}"
                releaseName "v${project.version}"
                overwrite true
            }

            if(project.tasks.findByName('deploy')) {
                if(project.tasks.containsKey('build')) {
                    project.deploy.mustRunAfter project.build
                    project.tasks['githubRelease'].mustRunAfter project.build
                }
                if(System.env.containsKey('PROMOTE')) {
                    project.deploy.dependsOn project.tasks['githubRelease']
                }
            } else {
                project.task('deploy') {
                    if(project.tasks.findByName('build')) {
                        mustRunAfter project.build
                    }
                    if(System.env.containsKey('PROMOTE')) {
                        dependsOn project.tasks['githubRelease']
                    }
                }
            }

        }
    }
}