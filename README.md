# gradle-release-helper

[![latest jitpack release](https://jitpack.io/v/warlordofmars/gradle-release-helper.svg)](https://jitpack.io/#warlordofmars/gradle-release-helper)

## Overview

Gradle plugin to provide automation and standardization for maintaining project version in git tag as well as providing automation and standardization for publishing releases to GitHub

## Setup

To use this plugin, the following buildscript repositories and dependencies must be configured:

```gradle
buildscript {
  repositories {
    maven { url 'https://jitpack.io' }
  }
  dependencies {
    classpath 'com.github.warlordofmars:gradle-release-helper:release-0.1.3'
  }
}
```

Then to apply the plugin:

```gradle
apply plugin: 'com.github.warlordofmars.gradle.release'
```

## Versioning

Versioning on this project is applied automatically on all changes using the [axion-release-plugin](https://github.com/allegro/axion-release-plugin).  Git tags are created for all released versions, and all available released versions can be viewed in the [Releases](https://github.com/warlordofmars/gradle-release-helper/releases) section of this project.

## Author

* **John Carter** - [warlordofmars](https://github.com/warlordofmars)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Using [axion-release-plugin](https://github.com/allegro/axion-release-plugin) to provide automatic versioning and git tagging
* Using [github-release-gradle-plugin](https://github.com/BreadMoirai/github-release-gradle-plugin) to automate publishing releases to GitHub
* Using the [warlordofmars](https://github.com/warlordofmars) custom gradle distribution [warlordofmars-gradle](https://github.com/warlordofmars/warlordofmars-gradle) in order to define default repositories to avoid duplication across all projects
* Using the [warlordofmars](https://github.com/warlordofmars) jenkins pipeline library [jenkins-library](https://github.com/warlordofmars/jenkins-library) for re-usable CI/CD pipeline components