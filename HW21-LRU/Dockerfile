# Используйте официальный образ Gradle для сборки приложения
FROM gradle:7.2-jdk11 as build

# Установите рабочую директорию в /app
WORKDIR /app

# Копируйте build.gradle и скачайте зависимости для кэширования
COPY build.gradle .
RUN gradle build --no-daemon --refresh-dependencies

# Копируйте исходный код приложения
COPY src ./src

# Соберите приложение
RUN gradle build

# Используйте официальный образ OpenJDK для запуска приложения
FROM openjdk:11-jre-slim

# Установите рабочую директорию в /app
WORKDIR /app

# Копируйте собранное приложение из предыдущего шага
COPY --from=build /app/build/libs/*.jar app.jar

# Откройте порт 8080
EXPOSE 8080

# Запустите приложение
CMD ["java", "-jar", "app.jar"]