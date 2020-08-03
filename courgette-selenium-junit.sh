#!/bin/sh

# This will invoke the gradle tasks that calls the JUnit Courgette-JVM runners.
# =============================================================================

./gradlew --stop
./gradlew runChromeTestsUsingJUnit &
./gradlew runFirefoxTestsUsingJUnit &
wait