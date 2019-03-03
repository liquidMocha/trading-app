To push to PWS:
`cf login -u username -p password`
`cf push trading-app-hanchen -p build/libs/trading-app-0.0.1-SNAPSHOT.jar -b https://github.com/cloudfoundry/java-buildpack.git`

As of now, I'm using 1G memory, 256MB of disk on PWS. Anything less than that would crash the application.