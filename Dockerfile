# ベースイメージとして OpenJDK を使用
FROM openjdk:11-jre-slim

# 作業ディレクトリを指定
WORKDIR /WasteScheduler

# アプリケーションの JAR ファイルをコンテナにコピー
COPY target/*.jar app.jar

# アプリケーションが使用するポートを公開
EXPOSE 8080

# アプリケーションを実行
CMD ["java", "-jar", "app.jar"]
