# Sistema de Gestión de Préstamos Universitario

## 🌐 Descripción
Sistema desarrollado en **Apache NetBeans IDE 25** para gestionar préstamos de equipos y salas, conectado a la base de datos Oracle 10g de la universidad.

## ⚠️ Requisitos Clave
1. **Equipos universitarios**:
   - Solo funciona en PCs de la universidad (conexión directa al servidor de BD)
   - Requiere red institucional o VPN activa

2. **Software necesario**:
   - Apache NetBeans IDE 25 (instalado en laboratorios)
   - Java JDK 1.8 u 11 (preconfigurado)
   - Driver JDBC `ojdbc6.jar` (ya incluido en el proyecto)

## 🛠 Configuración Técnica
- **Versión IDE**: Apache NetBeans 25
- **Java**: JDK 1.8/11 (compatible con Oracle 10g)
- **Base de datos**: 
  ```java
  // Configuración automática (no modificar)
  jdbc:oracle:thin:@servidor.universidad:1521:BDUNI
