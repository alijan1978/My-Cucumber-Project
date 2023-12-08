package Utils;

import org.apache.log4j.*;

public class Log {

    public static Logger log = Logger.getLogger(Log.class.getName());

// when the test starts, I should print the logs
// when my test stops, I should print the logs
// If I want to print any message in-between, I should print the logs

    public static void startTestCase(String testCaseName){

        log.info("----------------------------------------");
        log.info("****************************************");
        log.info("****************************************");
        log.info("********" + testCaseName + "*************");
    }

    public static void endTestCase(String testCaseName){

        log.info("-------------#########---------------------------");
        log.info("####################################");
        log.info("####################################");
        log.info("#########" + testCaseName +"########");
    }

    public static void info(String message){

        log.info(message);
    }

    public static void warning(String warning){

        log.info(warning);
    }
}
/* -------------- Maven Icon on right top corner is called Maven Life cycle-----------

 - Clean: Removes all the files generated by the previous build (Example: target folder) temporarily
 - Validate: Check the project is correct and all the necessary information is available (used by Devs)
  - Compile: Compile the source code of the project
  - Test: It runs the tests for the project (Clean, validate and compile) will execute together with Test function
  - Package: It packages the compiled code into a distributable format, such as: Jar or War files
  - Verify: It runs and checks on results of integration tests to ensure the quality criteria is met
  - Install: It installs the packages into Local Repositories
((Ex: when we add dependencies in pom.xml, it downloads into our  system, in Drive C: User --> package called " .m2 " contains all dependencies)
 - Site: It generates documentation for the project (used by Devs)
 - Deploy: Copies the final package to Remote Repository for sharing with other Developers or projects

 */