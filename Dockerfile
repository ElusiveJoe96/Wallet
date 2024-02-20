FROM openjdk:17
COPY . /target/Wallet-0.0.1-SNAPSHOT.jar
WORKDIR /src/main/java/com/example/wallet
CMD ["java", "WalletApplication"]
ENTRYPOINT ["java", "-jar", "/Wallet-0.0.1-SNAPSHOT.jar"]