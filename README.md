# Star Wars Destiny Card Library (Kotlin)
> SWDCL is a fun little project where I use Kotlin, Spring Boot, and Crnk to search and update card and set information
> for the Star Wars Destiny collectable card game.

## Development setup

### Dependencies

* [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [IntelliJ](https://www.jetbrains.com/idea/download/)

### Building
The application is built and run using Gradle, but also utilizes the Gradle Wrapper, so the only thing you'll
need to install is the JDK. Once that is installed, run gradlew
> `gradlew clean assemble`

### Testing
Tests are in JUnit and can be executed with Gradle
> `gradlew test`

### Running
Since the application is Spring Boot, you only need to execute the appropriate task through Gradle
> `gradlew bootRun`

where [file] is the name of the model import xml to be processed. The file will be removed and
put in the /process directory as it is being processed, /archive directory on success, 
or the /rejected directory if it is invalid. Error messages are available in ModelImportErrors.log.

## Contributing

### Branching
When contributing to this project, please create a corresponding bug or feature branch, with the issue number and a short description (e.g. *feat/N1-readme*). Push the branch to the remote as early and as often as desired so that tests can run appropriately.

### Pull Request
When ready to submit a pull request, please first squash your branch using
> `git rebase -i origin/master`

After the squash is complete, please simply submit a pull request to the master branch using the GitHub interface.
