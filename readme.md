To push to PWS:
`cf login -u username -p password`
`cf push trading-app-hanchen -p build/libs/trading-app-0.0.1-SNAPSHOT.jar -b https://github.com/cloudfoundry/java-buildpack.git`
