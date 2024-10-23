# ベースイメージとして OpenJDK を使用
FROM openjdk:11-jre-slim AS build

# 作業ディレクトリを指定
WORKDIR /WasteScheduler

# Gradle Wrapper と設定ファイルをコピー
COPY ./gradlew .
COPY ./gradle gradle
COPY ./build.gradle .
COPY ./settings.gradle .

# 依存関係をインストール
RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

# アプリケーションのソースコードをコピー
COPY ./src ./src

# アプリケーションをビルド
RUN ./gradlew build --no-daemon

# JAR ファイルを最終イメージにコピー
FROM openjdk:11-jre-slim
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "WasteScheduler.jar"]
