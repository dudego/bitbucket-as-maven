# bitbucket-as-maven

### Intro
A sample project which resolves library dependency from bitbucket as maven. This project can be imported in Android Studio as single project or different projects containing:

  - **corelib** - containing two modules 'corelibrary' and 'corelibapp'
  - **uilib** - containing two modules 'uilibrary' and 'uilibapp'
  - **application** - containing single module 'app'
   
'corelibrary' and 'uilibrary' are two library modules and their aar are uploaded as artifacts on bitbucket as maven.

Also, 'corelibapp' and 'uilibapp' are android application module which resolves their project dependencies locally to make development process easier.

Once library development is complete, artifact can be uploaded by running

```sh
$ ./gradlew :corelib:corelibrary assembleRelease uploadArchives
```

### Prerequisite

  - A bitbucket account configured with ssh key access
  
### Configuration

- Open *'versions.gradle'* and configure following properties
    ```groovy
    framework.packagename="com.bitbucketrepo.asmaven" //package name
    framework.company="dudego" //bitbucket username or company name
    framework.repository="bitbucket-maven-framework" //repository name
    ```
 - Create *gradle.properties* in global .gradle folder on your system with the following parameters 
    ```
    USERNAME=<username_here>
    PASSWORD=<password_here>
    ```
  - Initialize bitbtbucket repo with name defined above (bitbucket-maven-framework) with *'release'* as main branch. Check [this link](https://stackoverflow.com/questions/37550492/how-to-change-the-main-branch-in-bitbucket) for details.
  - Open 'corelib' project and edit *'corelibrary/gradle.properties'* to set 
    ```
    ARTIFACT_VERSION=0.0.3-alpha1 //version number
    ARTIFACT_NAME=lib-core //name of artifact
    ```
  - Upload artifact buy executing
    ```sh
    $ ./gradlew :corelib:corelibrary assembleRelease uploadArchives
    ```
    If there is some error please check log by adding *'--info'* flag

### Importing Artifact

To resolve dependeny add Maven repository to the list of repositories in your main build.gradle file:

```groovy
allprojects {
    repositories {
        handler.maven {
                credentials {
                    username FRAMEWORK_USERNAME
                    password FRAMEWORK_PASSWORD
                }
                url "https://api.bitbucket.org/1.0/repositories/$framework.company/$framework.repository/raw/releases"
            }
    }
}
```

Import this dependency as:

```groovy
    implementation "com.bitbucketrepo.asmaven:lib-core:0.0.3-alpha1"
```

For reference I've made this maven repository as public. Check [this link](https://bitbucket.org/dudego/bitbucket-maven-framework/overview) for reference.
 
