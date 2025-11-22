# ---------- 1) Build React frontend ----------
FROM node:18 AS frontend-build

WORKDIR /app/frontend

# Install dependencies
COPY Front_end/package*.json ./
RUN npm install

# Build frontend
COPY Front_end/ ./
RUN npm run build


# ---------- 2) Build Spring Boot backend ----------
FROM maven:3.9-eclipse-temurin-17 AS backend-build

WORKDIR /app

# Download dependencies
COPY Back_end/pom.xml .
RUN mvn -q dependency:go-offline

# Copy backend source
COPY Back_end/ .

# Copy built frontend into Spring Boot static folder
COPY --from=frontend-build /app/frontend/build ./src/main/resources/static/

# Build jar (skip tests for speed)
RUN mvn -q clean package -DskipTests


# ---------- 3) Final runtime image ----------
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built jar (exact name from your screenshot)
COPY --from=backend-build /app/target/joblisting-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]
