Betamax PoC
=======================

Setup the project with:

    wget https://raw.githubusercontent.com/betamaxteam/betamax/master/betamax.pem
    keytool -importcert -keystore $JAVA_HOME/jre/lib/security/cacerts -file betamax.pem -alias betamax -storepass changeit -noprompt

Run the project with:

    $ ./gradlew bootRun

Execute tests with:

    $ ./gradlew test
