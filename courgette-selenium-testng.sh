#!/bin/sh

# This will invoke the gradle tasks that calls the TestNG Courgette-JVM runners.
# ==============================================================================

./gradlew --stop
./gradlew runChromeTestsUsingTestNG &
./gradlew runFirefoxTestsUsingTestNG &
wait