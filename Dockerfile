# ベースイメージとして OpenJDK を使用
FROM openjdk:11-jre-slim AS build

# 作業ディレクトリを指定
WORKDIR /WasteScheduler

# Maven Wrapper と必要なファイルをコピー
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# 依存関係をインストール
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# アプリケーションのソースコードをコピー
COPY src ./src

# アプリケーションをビルド
RUN ./mvnw package

# JAR ファイルを最終イメージにコピー
FROM openjdk:11-jre-slim
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "WasteScheduler.jar"]
